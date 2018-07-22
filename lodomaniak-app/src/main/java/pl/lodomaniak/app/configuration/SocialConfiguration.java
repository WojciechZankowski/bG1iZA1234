package pl.lodomaniak.app.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import pl.lodomaniak.auth.social.CustomSocialUsersConnectionRepository;
import pl.lodomaniak.auth.social.SocialUserConnectionRepository;

@Configuration
@EnableSocial
public class SocialConfiguration implements SocialConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(SocialConfiguration.class);

    private final SocialUserConnectionRepository socialUserConnectionRepository;
    private final Environment environment;

    @Autowired
    public SocialConfiguration(final SocialUserConnectionRepository socialUserConnectionRepository,
            final Environment environment) {
        this.socialUserConnectionRepository = socialUserConnectionRepository;
        this.environment = environment;
    }

    @Override
    public void addConnectionFactories(final ConnectionFactoryConfigurer connectionFactoryConfigurer, final Environment environment) {
        final String facebookClientId = environment.getProperty("spring.social.facebook.client-id");
        final String facebookClientSecret = environment.getProperty("spring.social.facebook.client-secret");
        if (facebookClientId != null && facebookClientSecret != null) {
            LOG.debug("Configuring FacebookConnectionFactory");
            connectionFactoryConfigurer.addConnectionFactory(
                    new FacebookConnectionFactory(
                            facebookClientId,
                            facebookClientSecret
                    )
            );
        } else {
            LOG.error("Cannot configure FacebookConnectionFactory id or secret null");
        }
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(final ConnectionFactoryLocator connectionFactoryLocator) {
        return new CustomSocialUsersConnectionRepository(socialUserConnectionRepository, connectionFactoryLocator);
    }

    @Bean
    public ProviderSignInController providerSignInController(final ConnectionFactoryLocator connectionFactoryLocator,
            final UsersConnectionRepository usersConnectionRepository, final SignInAdapter signInAdapter) {
        ProviderSignInController providerSignInController = new ProviderSignInController(connectionFactoryLocator,
                usersConnectionRepository, signInAdapter);
        providerSignInController.setSignUpUrl("/social/signup");
        providerSignInController.setApplicationUrl(environment.getProperty("spring.application.url"));
        return providerSignInController;
    }

    @Bean
    public ProviderSignInUtils getProviderSignInUtils(final ConnectionFactoryLocator connectionFactoryLocator,
            final UsersConnectionRepository usersConnectionRepository) {
        return new ProviderSignInUtils(connectionFactoryLocator, usersConnectionRepository);
    }

}
