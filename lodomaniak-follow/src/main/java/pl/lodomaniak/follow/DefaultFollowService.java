package pl.lodomaniak.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.follow.api.FollowTO;
import pl.lodomaniak.follow.api.FollowType;
import pl.lodomaniak.follow.model.FollowEntity;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.spi.UserService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultFollowService implements FollowService {

    private final FollowRepository followRepository;
    private final FollowMapper followMapper;
    private final UserService userService;

    @Autowired
    public DefaultFollowService(final FollowRepository followRepository, final FollowMapper followMapper,
            final UserService userService) {
        this.followRepository = followRepository;
        this.followMapper = followMapper;
        this.userService = userService;
    }

    @Override
    public FollowTO addFollow(final FollowTO follow, final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());
        final FollowEntity savedEntity = followRepository.save(followMapper.map(follow, account.getId()));
        return followMapper.map(savedEntity);
    }

    @Override
    public void removeFollow(final Long followId, final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());
        followRepository.deleteByIdAndUserId(followId, account.getId());
    }

    @Override
    public List<Long> getFollowedObjects(final Long userId, final FollowType followType) {
        return followRepository.findAllByUserIdAndFollowType(userId, followType).stream()
                .map(FollowEntity::getFollowedObjectId)
                .collect(toList());
    }

}
