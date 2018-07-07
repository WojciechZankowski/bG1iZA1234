package pl.lodomaniak.user.api;

public final class PasswordResetTOBuilder {
    private String key;
    private String password;

    public PasswordResetTOBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public PasswordResetTOBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public PasswordResetTO build() {
        return new PasswordResetTO(key, password);
    }
}
