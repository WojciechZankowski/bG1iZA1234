package pl.lodomaniak.rating.model;

import pl.lodomaniak.core.entity.IEntity;
import pl.lodomaniak.rating.api.RatingType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "lodomaniak_rating")
public class RatingEntity implements IEntity {

    private static final long serialVersionUID = -4966472022452291133L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private RatingType ratingType;

    @NotNull
    @Column
    private Long ratedObjectId;

    @NotNull
    @Column
    private Long userId;

    public RatingEntity() {
    }

    public RatingEntity(
            final RatingType ratingType,
            final Long ratedObjectId,
            final Long userId) {
        this.ratingType = ratingType;
        this.ratedObjectId = ratedObjectId;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RatingEntity that = (RatingEntity) o;
        return Objects.equals(id, that.id) &&
                ratingType == that.ratingType &&
                Objects.equals(ratedObjectId, that.ratedObjectId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ratingType, ratedObjectId, userId);
    }

    @Override
    public String toString() {
        return "RatingEntity{" +
                "id=" + id +
                ", ratingType=" + ratingType +
                ", ratedObjectId=" + ratedObjectId +
                ", userId=" + userId +
                '}';
    }
}
