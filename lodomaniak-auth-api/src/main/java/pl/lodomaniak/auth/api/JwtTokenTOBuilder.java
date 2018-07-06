package pl.lodomaniak.auth.api;

public final class JwtTokenTOBuilder {
    private String idToken;

    public JwtTokenTOBuilder withIdToken(final String idToken) {
        this.idToken = idToken;
        return this;
    }

    public JwtTokenTO build() {
        return new JwtTokenTO(idToken);
    }
}
