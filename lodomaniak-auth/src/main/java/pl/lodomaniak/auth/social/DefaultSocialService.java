package pl.lodomaniak.auth.social;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Service;
import pl.lodomaniak.auth.api.AuthoritiesConstants;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.AccountTOBuilder;
import pl.lodomaniak.user.api.UserTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.spi.UserService;

@Service
public class DefaultSocialService implements SocialService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultSocialService.class);

    private final UserService userService;
    private final UsersConnectionRepository usersConnectionRepository;

    @Autowired
    public DefaultSocialService(final UserService userService, final UsersConnectionRepository usersConnectionRepository) {
        this.userService = userService;
        this.usersConnectionRepository = usersConnectionRepository;
    }

    @Override
    public void createUser(final Connection<?> connection) throws UserNotFoundException {
        if (connection == null) {
            LOG.error("Failed to create user, because connection is null.");
        }

        final UserProfile userProfile = connection.fetchUserProfile();

        final UserTO user = createUserIfNotExist(userProfile);

        final ConnectionRepository connectionRepository = usersConnectionRepository.createConnectionRepository(user.getLogin());
        connectionRepository.addConnection(connection);
    }

    private UserTO createUserIfNotExist(final UserProfile userProfile) throws UserNotFoundException {
        userService.registerAccount(map(userProfile));
        return userService.loadUserByUsername(userProfile.getEmail());
    }

    private AccountTO map(final UserProfile userProfile) {
        return new AccountTOBuilder()
                .withLogin(userProfile.getEmail())
                .withPassword(RandomStringUtils.random(10))
                .withFirstName(userProfile.getFirstName())
                .withLastName(userProfile.getLastName())
                .withEmail(userProfile.getEmail())
                .withActivated(true)
                .withAuthorities(Sets.newHashSet(AuthoritiesConstants.USER))
                .withLangKey("pl")
                .build();
    }

}
