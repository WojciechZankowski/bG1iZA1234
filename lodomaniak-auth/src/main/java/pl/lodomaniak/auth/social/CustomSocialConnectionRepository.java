package pl.lodomaniak.auth.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.NoSuchConnectionException;
import org.springframework.social.connect.NotConnectedException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.lodomaniak.auth.social.entity.SocialUserConnectionEntity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomSocialConnectionRepository implements ConnectionRepository {

    private final String userId;
    private final SocialUserConnectionRepository connectionRepository;
    private final ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    public CustomSocialConnectionRepository(final String userId, final SocialUserConnectionRepository connectionRepository,
            final ConnectionFactoryLocator connectionFactoryLocator) {
        this.userId = userId;
        this.connectionRepository = connectionRepository;
        this.connectionFactoryLocator = connectionFactoryLocator;
    }

    @Override
    public MultiValueMap<String, Connection<?>> findAllConnections() {
        final List<SocialUserConnectionEntity> socialUserConnections =
                connectionRepository.findAllByUserIdOrderByProviderIdAscRankAsc(userId);
        final List<Connection<?>> connections = socialUserConnectionsToConnections(socialUserConnections);

        final MultiValueMap<String, Connection<?>> connectionsByProviderId = new LinkedMultiValueMap<>();
        final Set<String> registeredProviderIds = connectionFactoryLocator.registeredProviderIds();
        for (String registeredProviderId : registeredProviderIds) {
            connectionsByProviderId.put(registeredProviderId, Collections.emptyList());
        }
        for (Connection<?> connection : connections) {
            String providerId = connection.getKey().getProviderId();
            if (connectionsByProviderId.get(providerId).size() == 0) {
                connectionsByProviderId.put(providerId, new LinkedList<>());
            }
            connectionsByProviderId.add(providerId, connection);
        }
        return connectionsByProviderId;
    }

    private List<Connection<?>> socialUserConnectionsToConnections(final List<SocialUserConnectionEntity> socialUserConnections) {
        return socialUserConnections.stream()
                .map(this::socialUserConnectionToConnection)
                .collect(Collectors.toList());
    }

    private Connection<?> socialUserConnectionToConnection(final SocialUserConnectionEntity socialUserConnection) {
        final ConnectionData connectionData = new ConnectionData(socialUserConnection.getProviderId(),
                socialUserConnection.getProviderUserId(),
                socialUserConnection.getDisplayName(),
                socialUserConnection.getProfileUrl(),
                socialUserConnection.getImageUrl(),
                socialUserConnection.getAccessToken(),
                socialUserConnection.getSecret(),
                socialUserConnection.getRefreshToken(),
                socialUserConnection.getExpireTime());
        final ConnectionFactory<?> connectionFactory = connectionFactoryLocator.getConnectionFactory(
                connectionData.getProviderId());
        return connectionFactory.createConnection(connectionData);
    }

    @Override
    public List<Connection<?>> findConnections(final String providerId) {
        final List<SocialUserConnectionEntity> socialUserConnections =
                connectionRepository.findAllByUserIdAndProviderIdOrderByRankAsc(userId, providerId);
        return socialUserConnectionsToConnections(socialUserConnections);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A> List<Connection<A>> findConnections(Class<A> apiType) {
        List<?> connections = findConnections(getProviderId(apiType));
        return (List<Connection<A>>) connections;
    }

    @Override
    public MultiValueMap<String, Connection<?>> findConnectionsToUsers(MultiValueMap<String, String> providerUserIdsByProviderId) {
        if (providerUserIdsByProviderId == null || providerUserIdsByProviderId.isEmpty()) {
            throw new IllegalArgumentException("Unable to execute find: no providerUsers provided");
        }

        MultiValueMap<String, Connection<?>> connectionsForUsers = new LinkedMultiValueMap<>();
        for (Map.Entry<String, List<String>> entry : providerUserIdsByProviderId.entrySet()) {
            String providerId = entry.getKey();
            List<String> providerUserIds = entry.getValue();
            List<Connection<?>> connections = providerUserIdsToConnections(providerId, providerUserIds);
            connections.forEach(connection -> connectionsForUsers.add(providerId, connection));
        }
        return connectionsForUsers;
    }

    private List<Connection<?>> providerUserIdsToConnections(String providerId, List<String> providerUserIds) {
        final List<SocialUserConnectionEntity> socialUserConnections = connectionRepository.findAllByUserIdAndProviderIdAndProviderUserIdIn(
                userId, providerId, providerUserIds);
        return socialUserConnectionsToConnections(socialUserConnections);
    }

    @Override
    public Connection<?> getConnection(ConnectionKey connectionKey) {
        SocialUserConnectionEntity socialUserConnection = connectionRepository.findOneByUserIdAndProviderIdAndProviderUserId(
                userId, connectionKey.getProviderId(), connectionKey.getProviderUserId());
        return Optional.ofNullable(socialUserConnection)
                .map(this::socialUserConnectionToConnection)
                .orElseThrow(() -> new NoSuchConnectionException(connectionKey));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A> Connection<A> getConnection(Class<A> apiType, String providerUserId) {
        String providerId = getProviderId(apiType);
        return (Connection<A>) getConnection(new ConnectionKey(providerId, providerUserId));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A> Connection<A> getPrimaryConnection(Class<A> apiType) {
        String providerId = getProviderId(apiType);
        Connection<A> connection = (Connection<A>) findPrimaryConnection(providerId);
        if (connection == null) {
            throw new NotConnectedException(providerId);
        }
        return connection;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A> Connection<A> findPrimaryConnection(Class<A> apiType) {
        String providerId = getProviderId(apiType);
        return (Connection<A>) findPrimaryConnection(providerId);
    }

    private Connection<?> findPrimaryConnection(String providerId) {
        List<SocialUserConnectionEntity> socialUserConnections = connectionRepository.findAllByUserIdAndProviderIdOrderByRankAsc(
                userId, providerId);
        if (socialUserConnections.size() > 0) {
            return socialUserConnectionToConnection(socialUserConnections.get(0));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void addConnection(Connection<?> connection) {
        Long rank = getNewMaxRank(connection.getKey().getProviderId()).longValue();
        SocialUserConnectionEntity socialUserConnectionToSave = connectionToUserSocialConnection(connection, rank);
        connectionRepository.save(socialUserConnectionToSave);
    }

    private Double getNewMaxRank(String providerId) {
        List<SocialUserConnectionEntity> socialUserConnections = connectionRepository.findAllByUserIdAndProviderIdOrderByRankAsc(userId, providerId);
        return socialUserConnections.stream()
                .mapToDouble(SocialUserConnectionEntity::getRank)
                .max()
                .orElse(0D) + 1D;
    }

    private SocialUserConnectionEntity connectionToUserSocialConnection(Connection<?> connection, Long rank) {
        ConnectionData connectionData = connection.createData();
        return new SocialUserConnectionEntity(null,
                userId,
                connection.getKey().getProviderId(),
                connection.getKey().getProviderUserId(),
                rank,
                connection.getDisplayName(),
                connection.getProfileUrl(),
                connection.getImageUrl(),
                connectionData.getAccessToken(),
                connectionData.getSecret(),
                connectionData.getRefreshToken(),
                connectionData.getExpireTime()
        );
    }

    @Override
    @Transactional
    public void updateConnection(Connection<?> connection) {
        SocialUserConnectionEntity socialUserConnection = connectionRepository.findOneByUserIdAndProviderIdAndProviderUserId(userId, connection.getKey().getProviderId(), connection.getKey().getProviderUserId());
        if (socialUserConnection != null) {
            SocialUserConnectionEntity socialUserConnectionToUdpate = connectionToUserSocialConnection(
                    connection, socialUserConnection.getRank());
            socialUserConnectionToUdpate.setId(socialUserConnection.getId());
            connectionRepository.save(socialUserConnectionToUdpate);
        }
    }

    @Override
    @Transactional
    public void removeConnections(String providerId) {
        connectionRepository.deleteByUserIdAndProviderId(userId, providerId);
    }

    @Override
    @Transactional
    public void removeConnection(ConnectionKey connectionKey) {
        connectionRepository.deleteByUserIdAndProviderIdAndProviderUserId(userId, connectionKey.getProviderId(), connectionKey.getProviderUserId());
    }

    private <A> String getProviderId(Class<A> apiType) {
        return connectionFactoryLocator.getConnectionFactory(apiType).getProviderId();
    }
}
