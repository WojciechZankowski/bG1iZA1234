package pl.zankowski.lmbd.auth.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;
import pl.zankowski.lmbd.core.Constants;
import pl.zankowski.lmbd.core.ITransferObject;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static pl.zankowski.lmbd.core.Constants.PASSWORD_MAX_LENGTH;
import static pl.zankowski.lmbd.core.Constants.PASSWORD_MIN_LENGTH;

@JsonPropertyOrder({"username", "password", "rememberMe"})
public class LoginTO implements ITransferObject {

    private static final long serialVersionUID = 8747603270043595048L;

    @Pattern(regexp = Constants.LOGIN_REGEX)
    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    private Boolean rememberMe;

    @JsonCreator
    public LoginTO(
            @JsonProperty("username") final String username,
            @JsonProperty("password") final String password,
            @JsonProperty("rememberMe") final Boolean rememberMe) {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe == null ? false : rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean isRememberMe() {
        return rememberMe;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LoginTO loginTO = (LoginTO) o;
        return Objects.equal(username, loginTO.username) &&
                Objects.equal(password, loginTO.password) &&
                Objects.equal(rememberMe, loginTO.rememberMe);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, password, rememberMe);
    }

    @Override
    public String toString() {
        return "LoginTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }
}
