package pl.lodomaniak.follow.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.lodomaniak.core.ITransferObject;

import java.util.Objects;

@JsonPropertyOrder({"id", "followType", "followedObjectId"})
public class FollowTO implements ITransferObject {

    private static final long serialVersionUID = 7526422802477193420L;

    private final Long id;
    private final FollowType followType;
    private final Long followedObjectId;

    @JsonCreator
    public FollowTO(
            @JsonProperty("id") final Long id,
            @JsonProperty("followType") final FollowType followType,
            @JsonProperty("followedObjectId") final Long followedObjectId) {
        this.id = id;
        this.followType = followType;
        this.followedObjectId = followedObjectId;
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FollowTO followTO = (FollowTO) o;
        return Objects.equals(id, followTO.id) &&
                followType == followTO.followType &&
                Objects.equals(followedObjectId, followTO.followedObjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, followType, followedObjectId);
    }

    @Override
    public String toString() {
        return "FollowTO{" +
                "id=" + id +
                ", followType=" + followType +
                ", followedObjectId=" + followedObjectId +
                '}';
    }

}
