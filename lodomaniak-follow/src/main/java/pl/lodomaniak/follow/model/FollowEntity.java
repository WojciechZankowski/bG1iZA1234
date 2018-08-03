package pl.lodomaniak.follow.model;

import pl.lodomaniak.follow.api.FollowType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "lodomaniak_follow")
public class FollowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FollowType followType;

    @NotNull
    @Column
    private Long followedObjectId;

    @NotNull
    @Column
    private Long userId;

    public FollowEntity() {
    }

    public FollowEntity(final FollowType followType, final Long followedObjectId, final Long userId) {
        this.followType = followType;
        this.followedObjectId = followedObjectId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public FollowType getFollowType() {
        return followType;
    }

    public Long getFollowedObjectId() {
        return followedObjectId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FollowEntity that = (FollowEntity) o;
        return Objects.equals(id, that.id) &&
                followType == that.followType &&
                Objects.equals(followedObjectId, that.followedObjectId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, followType, followedObjectId, userId);
    }

    @Override
    public String toString() {
        return "FollowEntity{" +
                "id=" + id +
                ", followType=" + followType +
                ", followedObjectId=" + followedObjectId +
                ", userId=" + userId +
                '}';
    }

}
