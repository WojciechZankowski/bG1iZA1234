package pl.zankowski.lmbd.user;

import pl.zankowski.lmbd.user.api.AccountTO;
import pl.zankowski.lmbd.user.api.UserTO;
import pl.zankowski.lmbd.user.api.exception.UserAlreadyExistsException;
import pl.zankowski.lmbd.user.api.exception.UserNotFoundException;

public interface UserService {

    void registerAccount(AccountTO account) throws UserAlreadyExistsException;

    AccountTO loadUserByUsername(String login) throws UserNotFoundException;

}
