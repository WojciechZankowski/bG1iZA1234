package pl.zankowski.lmbd.user.api;

import pl.zankowski.lmbd.user.entity.UserEntity;

public class AccountTOBuilder extends UserTOBuilder {

    private String password;

    public AccountTOBuilder() {
    }

    public AccountTOBuilder(final UserEntity userEntity) {
        super(userEntity);
        if (userEntity != null) {
            password = userEntity.getPassword();
        }
    }

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
