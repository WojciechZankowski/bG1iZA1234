package pl.lodomaniak.auth.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import pl.lodomaniak.auth.social.entity.SocialUserConnectionEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomSocialUsersConnectionRepository implements UsersConnectionRepository {

    private final SocialUserConnectionRepository connectionRepository;
    private final ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    public CustomSocialUsersConnectionRepository(final SocialUserConnectionRepository connectionRepository,
            final ConnectionFactoryLocator connectionFactoryLocator) {
        this.connectionRepository = connectionRepository;
        this.connectionFactoryLocator = connectionFactoryLocator;
    }

    @Override
    public List<String> findUserIdsWithConnection(final Connection<?> connection) {
        final ConnectionKey key = connection.getKey();
        final List<SocialUserConnectionEntity> socialUserConnections =
                connectionRepository.findAllByProviderIdAndProviderUserId(key.getProviderId(), key.getProviderUserId());
        return socialUserConnections.stream()
                .map(SocialUserConnectionEntity::getUserId)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> findUserIdsConnectedTo(final String providerId, final Set<String> providerUserIds) {
        final List<SocialUserConnectionEntity> socialUserConnections =
                connectionRepository.findAllByProviderIdAndProviderUserIdIn(providerId, providerUserIds);
        return socialUserConnections.stream()
                .map(SocialUserConnectionEntity::getUserId)
                .collect(Collectors.toSet());
    }

    @Override
    public ConnectionRepository createConnectionRepository(final String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        return new CustomSocialConnectionRepository(userId, connectionRepository, connectionFactoryLocator);
    }
}
