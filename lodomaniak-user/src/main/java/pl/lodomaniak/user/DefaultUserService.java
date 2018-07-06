package pl.lodomaniak.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lodomaniak.auth.api.AuthoritiesConstants;
import pl.lodomaniak.core.RandomUtil;
import pl.lodomaniak.mail.spi.MailService;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.exception.UserAlreadyExistsException;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.entity.UserEntity;
import pl.lodomaniak.user.entity.UserEntityBuilder;
import pl.lodomaniak.user.mapper.UserMapper;
import pl.lodomaniak.user.spi.UserService;

import java.time.Instant;

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
    public void registerAccount(final AccountTO account) throws UserAlreadyExistsException {
        userRepository.findOneByLogin(account.getLogin().toLowerCase())
                .map(user -> {
                    throw new UserAlreadyExistsException("Login already in use.");
                })
                .orElseGet(() -> userRepository.findOneByEmail(account.getEmail())
                        .map(user -> {
                            throw new UserAlreadyExistsException("Email already in use.");
                        })
                        .orElseGet(() -> {
                            mailService.sendActivationEmail(account);
                            return createUser(account);
                        }));
    }

    private UserEntity createUser(final AccountTO account) {
        final UserEntity user = new UserEntityBuilder(account)
                .addAuthority(authorityRepository.findById(AuthoritiesConstants.USER).get())
                .withPassword(passwordEncoder.encode(account.getPassword()))
                .withActivated(false)
                .withActivationKey(RandomUtil.generateActivationKey())
                .withCreatedBy("test")
                .withCreatedDate(Instant.now())
                .withLangKey("pl")
                .build();
        userRepository.save(user);

        LOG.debug("New user has been created: {}", user);

        return user;
    }

    @Override
    public AccountTO loadUserByUsername(final String login) throws UserNotFoundException {
        return userRepository.findOneWithAuthoritiesByLogin(login.toLowerCase())
                .map(userMapper::map)
                .orElseThrow(UserNotFoundException::new);
    }

}
