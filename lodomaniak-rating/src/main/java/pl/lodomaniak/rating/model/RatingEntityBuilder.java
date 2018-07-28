package pl.lodomaniak.rating.model;

import pl.lodomaniak.rating.api.RatingType;

public final class RatingEntityBuilder {

    private Long id;
    private RatingType ratingType;
    private Long ratedObjectId;
    private Long userId;

    public RatingEntityBuilder withId(final Long id) {
        this.id = id;
        return this;
    }

    public RatingEntityBuilder withRatingType(final RatingType ratingType) {
        this.ratingType = ratingType;
        return this;
    }

    public RatingEntityBuilder withRatedObjectId(final Long ratedObjectId) {
        this.ratedObjectId = ratedObjectId;
        return this;
    }

    public RatingEntityBuilder withUserId(final Long userId) {
        this.userId = userId;
        return this;
    }

    public RatingEntity build() {
        return new RatingEntity(ratingType, ratedObjectId, userId);
    }
}
