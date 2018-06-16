package pl.zankowski.lmbd.auth;

import pl.zankowski.lmbd.auth.api.JwtTokenTO;
import pl.zankowski.lmbd.auth.api.LoginTO;

public interface AuthService {

    JwtTokenTO createAuthToken(LoginTO login);

}
