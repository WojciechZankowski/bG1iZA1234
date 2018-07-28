package pl.lodomaniak.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingType;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.spi.UserService;

import java.util.List;

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
    public void addRating(final RatingTO rating, final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());
        ratingRepository.save(ratingMapper.map(rating, account.getId()));
    }

    @Override
    public void removeRating(final RatingTO rating, final User user) throws UserNotFoundException {
        final AccountTO account = userService.loadUserByUsername(user.getUsername());
        ratingRepository.delete(ratingMapper.map(rating, account.getId()));
    }

    @Override
    public List<RatingTO> getMostPopular(final RatingType ratingType, final List<Long> objectIds) {
        return null;
    }

}
