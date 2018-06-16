package pl.zankowski.lmbd.user.api;

import pl.zankowski.lmbd.user.entity.AuthorityEntity;
import pl.zankowski.lmbd.user.entity.UserEntity;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

public class UserTOBuilder {

    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private boolean activated;
    private String langKey;
    private String imageUrl;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;
    private Set<String> authorities;

    public UserTOBuilder() {
    }

    public UserTOBuilder(final UserEntity userEntity) {
        if (userEntity != null) {
            this.login = userEntity.getLogin();
            this.firstName = userEntity.getFirstName();
            this.lastName = userEntity.getLastName();
            this.email = userEntity.getEmail();
            this.activated = userEntity.isActivated();
            this.langKey = userEntity.getLangKey();
            this.imageUrl = userEntity.getImageUrl();
            this.createdBy = userEntity.getCreatedBy();
            this.createdDate = userEntity.getCreatedDate();
            this.lastModifiedBy = userEntity.getLastModifiedBy();
            this.lastModifiedDate = userEntity.getLastModifiedDate();
            this.authorities = userEntity.getAuthorities().stream()
                    .map(AuthorityEntity::getName)
                    .collect(Collectors.toSet());
        }
    }

    public String getLogin() {
        return login;
    }

    public UserTOBuilder withLogin(final String login) {
        this.login = login;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserTOBuilder withFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserTOBuilder withLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserTOBuilder withEmail(final String email) {
        this.email = email;
        return this;
    }

    public boolean isActivated() {
        return activated;
    }

    public UserTOBuilder withActivated(final boolean activated) {
        this.activated = activated;
        return this;
    }

    public String getLangKey() {
        return langKey;
    }

    public UserTOBuilder withLangKey(final String langKey) {
        this.langKey = langKey;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserTOBuilder withImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public UserTOBuilder withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public UserTOBuilder withCreatedDate(final Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public UserTOBuilder withLastModifiedBy(final String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public UserTOBuilder withLastModifiedDate(final Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public UserTOBuilder withAuthorities(final Set<String> authorities) {
        this.authorities = authorities;
        return this;
    }

    public UserTO build() {
        return new UserTO(login, firstName, lastName, email, activated, langKey, imageUrl, createdBy,
                createdDate, lastModifiedBy, lastModifiedDate, authorities);
    }
}
