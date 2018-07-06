package pl.lodomaniak.user.spi;

import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.exception.UserAlreadyExistsException;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

public interface UserService {

    void registerAccount(AccountTO account) throws UserAlreadyExistsException;

    AccountTO loadUserByUsername(String login) throws UserNotFoundException;

}
