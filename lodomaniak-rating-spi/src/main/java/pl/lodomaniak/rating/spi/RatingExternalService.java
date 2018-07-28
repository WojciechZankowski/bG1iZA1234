package pl.lodomaniak.rating.spi;

import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingType;

import java.util.List;

public interface RatingExternalService {

    List<RatingTO> getMostPopular(RatingType ratingType, List<Long> objectIds);

}
