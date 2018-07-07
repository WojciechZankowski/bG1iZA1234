package pl.lodomaniak.user.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"key", "password"})
public class PasswordResetTO {

    private final String key;
    private final String password;

    @JsonCreator
    public PasswordResetTO(
            @JsonProperty("key") final String key,
            @JsonProperty("password") final String password) {
        this.key = key;
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PasswordResetTO that = (PasswordResetTO) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, password);
    }

    @Override
    public String toString() {
        return "PasswordResetTO{" +
                "key='" + key + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
