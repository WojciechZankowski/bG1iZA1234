package pl.lodomaniak.follow;

import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.follow.api.FollowTO;
import pl.lodomaniak.follow.api.FollowType;
import pl.lodomaniak.follow.spi.FollowExternalService;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

public interface FollowService extends FollowExternalService {

    FollowTO getMyFollow(Long followedObjectId, FollowType followType, User user) throws UserNotFoundException;

    FollowTO addFollow(FollowTO follow, User user) throws UserNotFoundException;

    void removeFollow(Long followId, User user) throws UserNotFoundException;

}
