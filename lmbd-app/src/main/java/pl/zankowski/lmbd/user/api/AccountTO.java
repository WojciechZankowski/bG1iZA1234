package pl.zankowski.lmbd.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

import static pl.zankowski.lmbd.core.Constants.PASSWORD_MAX_LENGTH;
import static pl.zankowski.lmbd.core.Constants.PASSWORD_MIN_LENGTH;

public class AccountTO extends UserTO {

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private final String password;

    @JsonCreator
    public AccountTO(
            @JsonProperty("login") final String login,
            @JsonProperty("password") final String password,
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
        super(login, firstName, lastName, email, activated, langKey, imageUrl, createdBy, createdDate, lastModifiedBy, lastModifiedDate, authorities);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final AccountTO accountTO = (AccountTO) o;
        return Objects.equal(password, accountTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), password);
    }

    @Override
    public String toString() {
        return "AccountTO{" +
                "password='" + password + '\'' +
                "} " + super.toString();
    }
}
