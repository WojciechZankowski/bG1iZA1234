package pl.lodomaniak.rating;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodomaniak.rating.model.RatingEntity;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {



}
