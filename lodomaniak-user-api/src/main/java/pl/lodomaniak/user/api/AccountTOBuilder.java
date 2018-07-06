package pl.lodomaniak.user.api;

public class AccountTOBuilder extends AbstractUserTOBuilder<AccountTOBuilder> {

    private String password;

    public String getPassword() {
        return password;
    }

    public AccountTOBuilder withPassword(final String password) {
        this.password = password;
        return this;
    }

    public AccountTO build() {
        return new AccountTO(getLogin(), getPassword(), getFirstName(), getLastName(),
                getEmail(), isActivated(), getLangKey(), getImageUrl(), getCreatedBy(),
                getCreatedDate(), getLastModifiedBy(), getLastModifiedDate(), getAuthorities());
    }


}
