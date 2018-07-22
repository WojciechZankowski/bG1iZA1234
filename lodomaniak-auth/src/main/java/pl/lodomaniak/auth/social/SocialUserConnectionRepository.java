package pl.lodomaniak.auth.social;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.auth.social.entity.SocialUserConnectionEntity;

import java.util.List;
import java.util.Set;

public interface SocialUserConnectionRepository extends JpaRepository<SocialUserConnectionEntity, Long> {

    List<SocialUserConnectionEntity> findAllByProviderIdAndProviderUserId(String providerId, String providerUserId);

    List<SocialUserConnectionEntity> findAllByProviderIdAndProviderUserIdIn(String providerId, Set<String> providerUserIds);

    List<SocialUserConnectionEntity> findAllByUserIdOrderByProviderIdAscRankAsc(String userId);

    List<SocialUserConnectionEntity> findAllByUserIdAndProviderIdOrderByRankAsc(String userId, String providerId);

    List<SocialUserConnectionEntity> findAllByUserIdAndProviderIdAndProviderUserIdIn(String userId, String providerId, List<String> provideUserId);

    SocialUserConnectionEntity findOneByUserIdAndProviderIdAndProviderUserId(String userId, String providerId, String providerUserId);

    void deleteByUserIdAndProviderId(String userId, String providerId);

    void deleteByUserIdAndProviderIdAndProviderUserId(String userId, String providerId, String providerUserId);
}
