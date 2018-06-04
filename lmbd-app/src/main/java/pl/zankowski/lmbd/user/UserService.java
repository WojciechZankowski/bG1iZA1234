package pl.zankowski.lmbd.user;

import pl.zankowski.lmbd.user.api.AccountTO;
import pl.zankowski.lmbd.user.api.exception.UserExistsException;

public interface UserService {

    void registerAccount(final AccountTO account) throws UserExistsException;

}
