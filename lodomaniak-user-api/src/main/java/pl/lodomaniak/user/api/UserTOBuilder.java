package pl.lodomaniak.user.api;

public class UserTOBuilder extends AbstractUserTOBuilder<UserTOBuilder> {

    public UserTO build() {
        return new UserTO(getId(), getLogin(), getFirstName(), getLastName(), getEmail(), isActivated(), getLangKey(),
                getImageUrl(), getCreatedBy(), getCreatedDate(), getLastModifiedBy(), getLastModifiedDate(),
                getAuthorities());
    }

}
