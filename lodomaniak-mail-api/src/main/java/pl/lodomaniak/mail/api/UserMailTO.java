package pl.lodomaniak.mail.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"login", "email", "langKey", "activationKey", "resetKey"})
public class UserMailTO {

    private final String login;
    private final String email;
    private final String langKey;
    private final String activationKey;
    private final String resetKey;

    @JsonCreator
    public UserMailTO(
            @JsonProperty("login") final String login,
            @JsonProperty("email") final String email,
            @JsonProperty("langKey") final String langKey,
            @JsonProperty("activationKey") final String activationKey,
            @JsonProperty("resetKey") final String resetKey) {
        this.login = login;
        this.email = email;
        this.langKey = langKey;
        this.activationKey = activationKey;
        this.resetKey = resetKey;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getLangKey() {
        return langKey;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public String getResetKey() {
        return resetKey;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserMailTO that = (UserMailTO) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) &&
                Objects.equals(langKey, that.langKey) &&
                Objects.equals(activationKey, that.activationKey) &&
                Objects.equals(resetKey, that.resetKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email, langKey, activationKey, resetKey);
    }

    @Override
    public String toString() {
        return "UserMailTO{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", langKey='" + langKey + '\'' +
                ", activationKey='" + activationKey + '\'' +
                ", resetKey='" + resetKey + '\'' +
                '}';
    }
}
