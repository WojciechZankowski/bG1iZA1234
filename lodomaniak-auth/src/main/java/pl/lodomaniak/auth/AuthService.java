package pl.lodomaniak.auth;

import pl.lodomaniak.auth.api.FacebookLoginTO;
import pl.lodomaniak.auth.api.JwtTokenTO;
import pl.lodomaniak.auth.api.LoginTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

public interface AuthService {

    JwtTokenTO createAuthToken(LoginTO login);

    JwtTokenTO createAuthToken(FacebookLoginTO login) throws UserNotFoundException;

}
