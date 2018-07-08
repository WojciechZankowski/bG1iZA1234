package pl.lodomaniak.mail.api;

public final class UserMailTOBuilder {
    private String login;
    private String email;
    private String langKey;
    private String activationKey;
    private String resetKey;

    public UserMailTOBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserMailTOBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserMailTOBuilder withLangKey(String langKey) {
        this.langKey = langKey;
        return this;
    }

    public UserMailTOBuilder withActivationKey(String activationKey) {
        this.activationKey = activationKey;
        return this;
    }

    public UserMailTOBuilder withResetKey(String resetKey) {
        this.resetKey = resetKey;
        return this;
    }

    public UserMailTO build() {
        return new UserMailTO(login, email, langKey, activationKey, resetKey);
    }
}
