package pl.lodomaniak.rating;

import org.springframework.stereotype.Component;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingTOBuilder;
import pl.lodomaniak.rating.model.RatingEntity;
import pl.lodomaniak.rating.model.RatingEntityBuilder;

@Component
public class RatingMapper {

    public RatingTO map(final RatingEntity rating) {
        return new RatingTOBuilder()
                .withId(rating.getId())
                .withRatingType(rating.getRatingType())
                .withRatedObjectId(rating.getRatedObjectId())
                .build();
    }

    public RatingEntity map(final RatingTO rating, final Long userId) {
        return new RatingEntityBuilder()
                .withId(rating.getId())
                .withRatingType(rating.getRatingType())
                .withRatedObjectId(rating.getRatedObjectId())
                .withUserId(userId)
                .build();
    }

}
