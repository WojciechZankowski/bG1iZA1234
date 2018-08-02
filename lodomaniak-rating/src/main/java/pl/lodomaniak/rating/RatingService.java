package pl.lodomaniak.rating;

import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingType;
import pl.lodomaniak.rating.spi.RatingExternalService;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

import java.util.List;

public interface RatingService extends RatingExternalService {

    RatingTO getRating(RatingType ratingType, Long ratedObjectId, User user) throws UserNotFoundException;

    RatingTO addRating(RatingTO rating, User user) throws UserNotFoundException;

    void removeRating(Long ratingId, User user) throws UserNotFoundException;

    List<RatingTO> getMostPopular(RatingType ratingType, List<Long> objectIds);

}
