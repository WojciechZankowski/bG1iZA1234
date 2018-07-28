package pl.lodomaniak.rating.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.lodomaniak.core.ITransferObject;

import java.util.Objects;

@JsonPropertyOrder({"id", "ratingType", "ratedObjectId", "userId"})
public class RatingTO implements ITransferObject {

    private static final long serialVersionUID = 2067212957762901229L;

    private final Long id;
    private final RatingType ratingType;
    private final Long ratedObjectId;

    @JsonCreator
    public RatingTO(
            @JsonProperty("id") final Long id,
            @JsonProperty("ratingType") final RatingType ratingType,
            @JsonProperty("ratedObjectId") final Long ratedObjectId) {
        this.id = id;
        this.ratingType = ratingType;
        this.ratedObjectId = ratedObjectId;
    }

    public Long getId() {
        return id;
    }

    public RatingType getRatingType() {
        return ratingType;
    }

    public Long getRatedObjectId() {
        return ratedObjectId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RatingTO rating = (RatingTO) o;
        return Objects.equals(id, rating.id) &&
                ratingType == rating.ratingType &&
                Objects.equals(ratedObjectId, rating.ratedObjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ratingType, ratedObjectId);
    }

    @Override
    public String toString() {
        return "RatingTO{" +
                "id=" + id +
                ", ratingType=" + ratingType +
                ", ratedObjectId=" + ratedObjectId +
                '}';
    }
}
