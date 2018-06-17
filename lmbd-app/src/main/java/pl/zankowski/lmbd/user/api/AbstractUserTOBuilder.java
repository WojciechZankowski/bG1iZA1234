package pl.zankowski.lmbd.user.api;

import pl.zankowski.lmbd.user.entity.AuthorityEntity;
import pl.zankowski.lmbd.user.entity.UserEntity;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractUserTOBuilder<B> {

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

    public String getLogin() {
        return login;
    }

    public B withLogin(final String login) {
        this.login = login;
        return (B) this;
    }

    public String getFirstName() {
        return firstName;
    }

    public B withFirstName(final String firstName) {
        this.firstName = firstName;
        return (B) this;
    }

    public String getLastName() {
        return lastName;
    }

    public B withLastName(final String lastName) {
        this.lastName = lastName;
        return (B) this;
    }

    public String getEmail() {
        return email;
    }

    public B withEmail(final String email) {
        this.email = email;
        return (B) this;
    }

    public boolean isActivated() {
        return activated;
    }

    public B withActivated(final boolean activated) {
        this.activated = activated;
        return (B) this;
    }

    public String getLangKey() {
        return langKey;
    }

    public B withLangKey(final String langKey) {
        this.langKey = langKey;
        return (B) this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public B withImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
        return (B) this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public B withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return (B) this;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public B withCreatedDate(final Instant createdDate) {
        this.createdDate = createdDate;
        return (B) this;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public B withLastModifiedBy(final String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return (B) this;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public B withLastModifiedDate(final Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return (B) this;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public B withAuthorities(final Set<String> authorities) {
        this.authorities = authorities;
        return (B) this;
    }


}
