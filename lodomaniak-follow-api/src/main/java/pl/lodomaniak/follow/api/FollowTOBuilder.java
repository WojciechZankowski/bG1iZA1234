package pl.lodomaniak.follow.api;

public final class FollowTOBuilder {
    private Long id;
    private FollowType followType;
    private Long followedObjectId;

    public FollowTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FollowTOBuilder withFollowType(FollowType followType) {
        this.followType = followType;
        return this;
    }

    public FollowTOBuilder withFollowedObjectId(Long followedObjectId) {
        this.followedObjectId = followedObjectId;
        return this;
    }

    public FollowTO build() {
        return new FollowTO(id, followType, followedObjectId);
    }
}
