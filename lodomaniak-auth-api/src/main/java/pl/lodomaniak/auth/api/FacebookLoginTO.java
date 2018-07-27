package pl.lodomaniak.auth.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.lodomaniak.core.ITransferObject;

import java.util.Objects;

@JsonPropertyOrder({"accessToken"})
public class FacebookLoginTO implements ITransferObject {

    private static final long serialVersionUID = -4512583596915713016L;

    private final String accessToken;

    @JsonCreator
    public FacebookLoginTO(
            @JsonProperty("accessToken") final String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FacebookLoginTO that = (FacebookLoginTO) o;
        return Objects.equals(accessToken, that.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken);
    }

    @Override
    public String toString() {
        return "FacebookLoginTO{" +
                "accessToken='" + accessToken + '\'' +
                '}';
    }
}
