package pl.lodomaniak.auth.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import pl.lodomaniak.core.ITransferObject;

public class JwtTokenTO implements ITransferObject {

    private static final long serialVersionUID = -5510851746442387124L;

    private final String idToken;

    public JwtTokenTO(final String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("id_token")
    public String getIdToken() {
        return idToken;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final JwtTokenTO that = (JwtTokenTO) o;
        return Objects.equal(idToken, that.idToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idToken);
    }

    @Override
    public String toString() {
        return "JwtTokenTO{" +
                "idToken='" + idToken + '\'' +
                '}';
    }
}
