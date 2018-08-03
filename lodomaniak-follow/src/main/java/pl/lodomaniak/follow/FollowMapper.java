package pl.lodomaniak.follow;

import org.springframework.stereotype.Component;
import pl.lodomaniak.follow.api.FollowTO;
import pl.lodomaniak.follow.api.FollowTOBuilder;
import pl.lodomaniak.follow.model.FollowEntity;
import pl.lodomaniak.follow.model.FollowEntityBuilder;

@Component
public class FollowMapper {

    public FollowTO map(final FollowEntity follow) {
        return new FollowTOBuilder()
                .withId(follow.getId())
                .withFollowType(follow.getFollowType())
                .withFollowedObjectId(follow.getFollowedObjectId())
                .build();
    }

    public FollowEntity map(final FollowTO follow, Long userId) {
        return new FollowEntityBuilder()
                .withFollowType(follow.getFollowType())
                .withFollowedObjectId(follow.getFollowedObjectId())
                .withUserId(userId)
                .build();
    }

}
