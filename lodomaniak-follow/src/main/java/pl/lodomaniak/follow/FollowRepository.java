package pl.lodomaniak.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.follow.api.FollowType;
import pl.lodomaniak.follow.model.FollowEntity;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<FollowEntity, Long> {

    Optional<FollowEntity> findOneByFollowTypeAndFollowedObjectIdAndUserId(FollowType followType, Long followedObjectId, Long userId);

    List<FollowEntity> findAllByUserIdAndFollowType(Long userId, FollowType followType);

    void deleteByIdAndUserId(Long followId, Long userId);

}
