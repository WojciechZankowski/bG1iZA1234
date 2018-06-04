package pl.zankowski.lmbd.user.entity;

import pl.zankowski.lmbd.user.api.AccountTO;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public final class UserEntityBuilder {

    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private boolean activated;
    private String langKey;
    private String imageUrl;
    private String activationKey;
    private String resetKey;
    private Instant resetDate;
    private Set<AuthorityEntity> authorities = new HashSet<>();

    public UserEntityBuilder() {
    }

    public UserEntityBuilder(final AccountTO account) {
        if (account != null) {
            this.login = account.getLogin();
            this.firstName = account.getFirstName();
            this.lastName = account.getLastName();
            this.email = account.getEmail();
            this.imageUrl = account.getImageUrl();
            this.langKey = account.getLangKey();
        }
    }

    public UserEntityBuilder withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public UserEntityBuilder withCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public UserEntityBuilder withLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public UserEntityBuilder withLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public UserEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntityBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserEntityBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntityBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntityBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEntityBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntityBuilder withActivated(boolean activated) {
        this.activated = activated;
        return this;
    }

    public UserEntityBuilder withLangKey(String langKey) {
        this.langKey = langKey;
        return this;
    }

    public UserEntityBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public UserEntityBuilder withActivationKey(String activationKey) {
        this.activationKey = activationKey;
        return this;
    }

    public UserEntityBuilder withResetKey(String resetKey) {
        this.resetKey = resetKey;
        return this;
    }

    public UserEntityBuilder withResetDate(Instant resetDate) {
        this.resetDate = resetDate;
        return this;
    }

    public UserEntityBuilder withAuthorities(Set<AuthorityEntity> authorities) {
        this.authorities = authorities;
        return this;
    }

    public UserEntityBuilder addAuthority(final AuthorityEntity authorityEntity) {
        this.authorities.add(authorityEntity);
        return this;
    }

    public UserEntity build() {
        return new UserEntity(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate, login, password,
                firstName, lastName, email, activated, langKey, imageUrl, activationKey, resetKey, resetDate,
                authorities);
    }
}
