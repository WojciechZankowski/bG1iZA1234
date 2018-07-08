package pl.lodomaniak.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"email"})
public class PasswordResetRequestTO {

    private final String email;

    @JsonCreator
    public PasswordResetRequestTO(
            @JsonProperty("email") final String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PasswordResetRequestTO that = (PasswordResetRequestTO) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "PasswordResetRequestTO{" +
                "email='" + email + '\'' +
                '}';
    }
}
