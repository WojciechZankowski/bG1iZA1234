package pl.lodomaniak.rating;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.lodomaniak.rating.api.RatingType;
import pl.lodomaniak.rating.model.RatingEntity;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

    Optional<RatingEntity> findOneByRatingTypeAndRatedObjectIdAndUserId(RatingType ratingType, Long ratedObjectId, Long userId);

    @Query("SELECT r FROM RatingEntity r WHERE r.ratedObjectId IN :ratedObjectIds" +
            " AND r.ratingType = :ratingType GROUP BY r.ratedObjectId ORDER BY count(*) DESC")
    List<RatingEntity> findTopByRatedObjectId(@Param("ratedObjectIds") List<Long> ratedObjectIds,
            @Param("ratingType") RatingType ratingType, Pageable pageable);

    void deleteByIdAndUserId(Long ratingId, Long userId);

}
