package pl.lodomaniak.user.spi;

import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.PasswordResetTO;
import pl.lodomaniak.user.api.UserTO;
import pl.lodomaniak.user.api.exception.UserAlreadyExistsException;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

public interface UserService {

    void registerAccount(AccountTO account) throws UserAlreadyExistsException;

    UserTO activateAccount(String key) throws UserNotFoundException;

    UserTO getAccount() throws UserNotFoundException;

    void initPasswordReset(String email) throws UserNotFoundException;

    void resetPassword(PasswordResetTO passwordReset) throws UserNotFoundException;

    AccountTO loadUserByUsername(String login) throws UserNotFoundException;

}
