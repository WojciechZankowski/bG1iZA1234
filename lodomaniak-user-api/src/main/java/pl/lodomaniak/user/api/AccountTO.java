package pl.lodomaniak.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import pl.lodomaniak.core.Constants;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

public class AccountTO extends UserTO {

    private static final long serialVersionUID = 1736304307129323345L;

    @Size(min = Constants.PASSWORD_MIN_LENGTH, max = Constants.PASSWORD_MAX_LENGTH)
    private final String password;

    @JsonCreator
    public AccountTO(
            @JsonProperty("id") final Long id,
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
        super(id, login, firstName, lastName, email, activated, langKey, imageUrl, createdBy, createdDate,
                lastModifiedBy, lastModifiedDate, authorities);
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
