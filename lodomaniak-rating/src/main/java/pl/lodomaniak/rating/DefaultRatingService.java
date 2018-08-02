package pl.lodomaniak.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingType;
import pl.lodomaniak.rating.model.RatingEntity;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.spi.UserService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultRatingService implements RatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;
    private final UserService userService;

    @Autowired
    public DefaultRatingService(final RatingRepository ratingRepository, final RatingMapper ratingMapper,
            final UserService userService) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
        this.userService = userService;
    }

    @Override
    public RatingTO getRating(final RatingType ratingType, final Long ratedObjectId, final User user)
            throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());
        return ratingRepository.findOneByRatingTypeAndRatedObjectIdAndUserId(ratingType, ratedObjectId, account.getId())
                .map(ratingMapper::map)
                .orElse(null);
    }

    @Override
    public RatingTO addRating(final RatingTO rating, final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());
        return ratingMapper.map(ratingRepository.save(ratingMapper.map(rating, account.getId())));
    }

    @Transactional
    @Override
    public void removeRating(final Long ratingId, final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());
        ratingRepository.deleteByIdAndUserId(ratingId, account.getId());
    }

    @Override
    public List<RatingTO> getMostPopular(final RatingType ratingType, final List<Long> objectIds) {
        return ratingRepository.findTopByRatedObjectId(objectIds, ratingType, PageRequest.of(0, 10)).stream()
                .map(ratingMapper::map)
                .collect(toList());
    }

}
