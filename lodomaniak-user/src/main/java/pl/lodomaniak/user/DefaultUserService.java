package pl.lodomaniak.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lodomaniak.auth.api.AuthoritiesConstants;
import pl.lodomaniak.auth.api.SecurityUtils;
import pl.lodomaniak.core.RandomUtil;
import pl.lodomaniak.mail.spi.MailService;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.PasswordResetRequestTO;
import pl.lodomaniak.user.api.PasswordResetTO;
import pl.lodomaniak.user.api.UserTO;
import pl.lodomaniak.user.api.exception.UserAlreadyExistsException;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.entity.UserEntity;
import pl.lodomaniak.user.entity.UserEntityBuilder;
import pl.lodomaniak.user.mapper.UserMapper;
import pl.lodomaniak.user.spi.UserService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
    private final UserMapper userMapper;

    @Autowired
    public DefaultUserService(
            final UserRepository userRepository,
            final AuthorityRepository authorityRepository,
            final PasswordEncoder passwordEncoder,
            final MailService mailService,
            final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
        this.userMapper = userMapper;
    }

    @Override
    public AccountTO registerAccount(final AccountTO account) throws UserAlreadyExistsException {
        return (AccountTO) userRepository.findOneByLogin(account.getLogin().toLowerCase())
                .map(user -> {
                    throw new UserAlreadyExistsException("Login already in use.");
                })
                .orElseGet(() -> userRepository.findOneByEmail(account.getEmail())
                        .map(user -> {
                            throw new UserAlreadyExistsException("Email already in use.");
                        })
                        .orElseGet(() -> {
                            final UserEntity user = createUser(account);
                            if (!account.isActivated()) {
                                mailService.sendActivationEmail(userMapper.mapToUserMail(user));
                            }
                            return userMapper.map(user);
                        }));
    }

    private UserEntity createUser(final AccountTO account) {
        final UserEntity user = new UserEntityBuilder(account)
                .addAuthority(authorityRepository.findById(AuthoritiesConstants.USER).get())
                .withPassword(passwordEncoder.encode(account.getPassword()))
                .withActivated(account.isActivated())
                .withActivationKey(account.isActivated() ? null : RandomUtil.generateActivationKey())
                .withCreatedBy("test")
                .withCreatedDate(Instant.now())
                .withLangKey("pl")
                .build();
        userRepository.save(user);

        LOG.debug("New user has been created: {}", user);

        return user;
    }

    @Override
    public UserTO activateAccount(final String key) throws UserNotFoundException {
        return userRepository.findOneByActivationKey(key)
                .map(this::activateAccount)
                .orElseThrow(UserNotFoundException::new);
    }

    private UserTO activateAccount(final UserEntity user) {
        final UserEntity userEntity = userRepository.save(new UserEntityBuilder(user)
                .withActivated(true)
                .withActivationKey(null)
                .build());
        return userMapper.map(userEntity);
    }

    @Override
    public UserTO getAccount() throws UserNotFoundException {
        return loadUserByUsername(SecurityUtils.getCurrentUserLogin());
    }

    @Override
    public void initPasswordReset(final PasswordResetRequestTO request) throws UserNotFoundException {
        final UserEntity user = userRepository.findOneByEmail(request.getEmail())
                .filter(UserEntity::isActivated)
                .map(this::initPasswordReset)
                .orElseThrow(UserNotFoundException::new);

        mailService.sendResetPasswordEmail(userMapper.mapToUserMail(user));
    }

    private UserEntity initPasswordReset(final UserEntity user) {
        return userRepository.save(new UserEntityBuilder(user)
                .withResetKey(RandomUtil.generateResetKey())
                .withResetDate(Instant.now())
                .build());
    }

    @Override
    public void resetPassword(final PasswordResetTO passwordReset) throws UserNotFoundException {
        userRepository.findOneByResetKey(passwordReset.getKey())
                .filter(user -> isResetKeyExpired(user.getResetDate()))
                .map(user -> resetPassword(user, passwordReset))
                .orElseThrow(UserNotFoundException::new);
    }

    private boolean isResetKeyExpired(final Instant resetDate) {
        return resetDate.isAfter(Instant.now().minus(1, ChronoUnit.DAYS));
    }

    private UserEntity resetPassword(final UserEntity user, final PasswordResetTO passwordReset) {
        return userRepository.save(new UserEntityBuilder(user)
                .withPassword(passwordEncoder.encode(passwordReset.getPassword()))
                .withResetDate(null)
                .withResetKey(null)
                .build());
    }

    @Override
    public AccountTO loadUserByUsername(final String login) throws UserNotFoundException {
        return userRepository.findOneWithAuthoritiesByLogin(login.toLowerCase())
                .map(userMapper::map)
                .orElseThrow(UserNotFoundException::new);
    }

}
