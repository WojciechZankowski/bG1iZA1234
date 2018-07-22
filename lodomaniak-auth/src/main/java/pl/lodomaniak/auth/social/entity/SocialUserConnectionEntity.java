package pl.lodomaniak.auth.social.entity;

import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "lodomaniak_social_user_connection")
public class SocialUserConnectionEntity implements IEntity {

    private static final long serialVersionUID = -4320964601092829575L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String userId;

    @NotNull
    @Column
    private String providerId;

    @NotNull
    @Column
    private String providerUserId;

    @NotNull
    @Column
    private Long rank;

    @Column
    private String displayName;

    @Column
    private String profileUrl;

    @Column
    private String imageUrl;

    @NotNull
    @Column
    private String accessToken;

    @Column
    private String secret;

    @Column
    private String refreshToken;

    @Column
    private Long expireTime;

    public SocialUserConnectionEntity() {
    }

    public SocialUserConnectionEntity(
            final Long id,
            @NotNull final String userId,
            @NotNull final String providerId,
            @NotNull final String providerUserId,
            @NotNull final Long rank,
            final String displayName,
            final String profileUrl,
            final String imageUrl,
            @NotNull final String accessToken,
            final String secret,
            final String refreshToken,
            final Long expireTime) {
        this.id = id;
        this.userId = userId;
        this.providerId = providerId;
        this.providerUserId = providerUserId;
        this.rank = rank;
        this.displayName = displayName;
        this.profileUrl = profileUrl;
        this.imageUrl = imageUrl;
        this.accessToken = accessToken;
        this.secret = secret;
        this.refreshToken = refreshToken;
        this.expireTime = expireTime;
    }

    public Long getId() {
        return id;
    }

    public SocialUserConnectionEntity setId(final Long id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public Long getRank() {
        return rank;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getSecret() {
        return secret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final SocialUserConnectionEntity that = (SocialUserConnectionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(providerId, that.providerId) &&
                Objects.equals(providerUserId, that.providerUserId) &&
                Objects.equals(rank, that.rank) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(profileUrl, that.profileUrl) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(secret, that.secret) &&
                Objects.equals(refreshToken, that.refreshToken) &&
                Objects.equals(expireTime, that.expireTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, providerId, providerUserId, rank, displayName, profileUrl, imageUrl,
                accessToken, secret, refreshToken, expireTime);
    }

    @Override
    public String toString() {
        return "SocialUserConnectionEntity{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", providerId='" + providerId + '\'' +
                ", providerUserId='" + providerUserId + '\'' +
                ", rank=" + rank +
                ", displayName='" + displayName + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", secret='" + secret + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}
