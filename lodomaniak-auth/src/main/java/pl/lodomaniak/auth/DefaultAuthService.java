package pl.lodomaniak.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.lodomaniak.auth.api.JwtTokenTO;
import pl.lodomaniak.auth.api.JwtTokenTOBuilder;
import pl.lodomaniak.auth.api.LoginTO;
import pl.lodomaniak.auth.jwt.TokenProvider;

@Service
public class DefaultAuthService implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;

    @Autowired
    public DefaultAuthService(final AuthenticationManager authenticationManager, final TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public JwtTokenTO createAuthToken(final LoginTO login) {
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                login.getUsername(), login.getPassword());

        final Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new JwtTokenTOBuilder()
                .withIdToken(tokenProvider.createAuthToken(authentication, login.isRememberMe()))
                .build();
    }

}
