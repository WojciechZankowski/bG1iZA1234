package pl.lodomaniak.auth;

import pl.lodomaniak.auth.api.JwtTokenTO;
import pl.lodomaniak.auth.api.LoginTO;

public interface AuthService {

    JwtTokenTO createAuthToken(LoginTO login);

}
