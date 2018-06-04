package pl.zankowski.lmbd.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import pl.zankowski.lmbd.core.Constants;
import pl.zankowski.lmbd.core.ITransferObject;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

public class UserTO implements ITransferObject {

    private static final long serialVersionUID = -5639378155048073249L;

    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 100)
    private final String login;

    @Size(max = 50)
    private final String firstName;

    @Size(max = 50)
    private final String lastName;

    @Email
    @Size(min = 5, max = 100)
    private final String email;

    @NotNull
    private final boolean activated;

    @Size(min = 2, max = 5)
    private final String langKey;

    @Size(max = 256)
    private final String imageUrl;

    private final String createdBy;

    private final Instant createdDate;

    private final String lastModifiedBy;

    private final Instant lastModifiedDate;

    private final Set<String> authorities;

    @JsonCreator
    public UserTO(
            @JsonProperty("login") final String login,
            @JsonProperty("firstName") final String firstName,
            @JsonProperty("lastName") final String lastName,
            @JsonProperty("email") final String email,
            @JsonProperty("activated") final boolean activated,
            @JsonProperty("langKey") final String langKey,
            @JsonProperty("imageUrl") final String imageUrl,
            @JsonProperty("createdBy") final String createdBy,
            @JsonProperty("createdDate") final Instant createdDate,
            @JsonProperty("lastModifiedBy") final String lastModifiedBy,
            @JsonProperty("lastModifiedDate") final Instant lastModifiedDate,
            @JsonProperty("authorities") final Set<String> authorities) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.langKey = langKey;
        this.imageUrl = imageUrl;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.authorities = authorities;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActivated() {
        return activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserTO userTO = (UserTO) o;
        return activated == userTO.activated &&
                Objects.equal(login, userTO.login) &&
                Objects.equal(firstName, userTO.firstName) &&
                Objects.equal(lastName, userTO.lastName) &&
                Objects.equal(email, userTO.email) &&
                Objects.equal(langKey, userTO.langKey) &&
                Objects.equal(imageUrl, userTO.imageUrl) &&
                Objects.equal(createdBy, userTO.createdBy) &&
                Objects.equal(createdDate, userTO.createdDate) &&
                Objects.equal(lastModifiedBy, userTO.lastModifiedBy) &&
                Objects.equal(lastModifiedDate, userTO.lastModifiedDate) &&
                Objects.equal(authorities, userTO.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(login, firstName, lastName, email, activated, langKey, imageUrl, createdBy,
                createdDate, lastModifiedBy, lastModifiedDate, authorities);
    }

    @Override
    public String toString() {
        return "UserTO{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activated=" + activated +
                ", langKey='" + langKey + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                ", authorities=" + authorities +
                '}';
    }
}
