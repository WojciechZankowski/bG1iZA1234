package pl.lodomaniak.rating.api;

public final class RatingTOBuilder {
    private Long id;
    private RatingType ratingType;
    private Long ratedObjectId;

    public RatingTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public RatingTOBuilder withRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
        return this;
    }

    public RatingTOBuilder withRatedObjectId(Long ratedObjectId) {
        this.ratedObjectId = ratedObjectId;
        return this;
    }

    public RatingTO build() {
        return new RatingTO(id, ratingType, ratedObjectId);
    }
}
