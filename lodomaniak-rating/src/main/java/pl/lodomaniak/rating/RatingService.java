package pl.lodomaniak.rating;

import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingType;
import pl.lodomaniak.rating.spi.RatingExternalService;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

import java.util.List;

public interface RatingService extends RatingExternalService {

    void addRating(RatingTO rating, User user) throws UserNotFoundException;

    void removeRating(RatingTO rating, User user) throws UserNotFoundException;

    List<RatingTO> getMostPopular(RatingType ratingType, List<Long> objectIds);

}
