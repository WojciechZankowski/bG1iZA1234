package pl.lodomaniak.follow.spi;

import pl.lodomaniak.follow.api.FollowType;

import java.util.List;

public interface FollowExternalService {

    List<Long> getFollowedObjects(Long userId, final FollowType followType);

}
