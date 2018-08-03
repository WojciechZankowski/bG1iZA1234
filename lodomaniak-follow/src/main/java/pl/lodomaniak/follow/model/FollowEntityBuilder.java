package pl.lodomaniak.follow.model;

import pl.lodomaniak.follow.api.FollowType;

public final class FollowEntityBuilder {

    private FollowType followType;
    private Long followedObjectId;
    private Long userId;

    public FollowEntityBuilder withFollowType(FollowType followType) {
        this.followType = followType;
        return this;
    }

    public FollowEntityBuilder withFollowedObjectId(Long followedObjectId) {
        this.followedObjectId = followedObjectId;
        return this;
    }

    public FollowEntityBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public FollowEntity build() {
        return new FollowEntity(followType, followedObjectId, userId);
    }

}
