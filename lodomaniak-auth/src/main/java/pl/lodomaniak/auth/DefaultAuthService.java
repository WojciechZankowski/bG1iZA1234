package pl.lodomaniak.auth;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.lodomaniak.auth.api.FacebookLoginTO;
import pl.lodomaniak.auth.api.JwtTokenTO;
import pl.lodomaniak.auth.api.JwtTokenTOBuilder;
import pl.lodomaniak.auth.api.LoginTO;
import pl.lodomaniak.auth.jwt.TokenProvider;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;
import pl.lodomaniak.core.exception.LodomaniakSystemException;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.AccountTOBuilder;
import pl.lodomaniak.user.api.exception.UserAlreadyExistsException;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
import pl.lodomaniak.user.spi.UserService;

@Service
public class DefaultAuthService implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final LodomaniakConfigurationProperties properties;

    @Autowired
    public DefaultAuthService(final AuthenticationManager authenticationManager, final TokenProvider tokenProvider,
            final UserService userService, final LodomaniakConfigurationProperties properties) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.properties = properties;
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

    @Override
    public JwtTokenTO createAuthToken(final FacebookLoginTO login) throws UserNotFoundException {
        final User facebookUser = getFacebookUser(login);
        final AccountTO user = fetchUser(facebookUser);

        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getLogin(), facebookUser.getId());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return new JwtTokenTOBuilder()
                .withIdToken(tokenProvider.createAuthToken(authenticationToken, true))
                .build();
    }

    private AccountTO fetchUser(final User user) throws UserNotFoundException {
        try {
            return userService.registerAccount(map(user));
        } catch (final UserAlreadyExistsException e) {
            // Ignore
        }
        return userService.loadUserByUsername(user.getEmail() == null ? user.getId() : user.getEmail());
    }

    private AccountTO map(final User user) {
        return new AccountTOBuilder()
                .withLogin(user.getEmail() == null ? user.getId() : user.getEmail())
                .withPassword(RandomStringUtils.random(10))
                .withEmail(user.getEmail())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withLangKey("pl")
                .withActivated(true)
                .build();
    }

    private User getFacebookUser(final FacebookLoginTO login) {
        final DefaultFacebookClient defaultFacebookClient = new DefaultFacebookClient(Version.LATEST);
        final FacebookClient.AccessToken accessToken = defaultFacebookClient.obtainAppAccessToken(
                properties.getFacebook().getAppId(), properties.getFacebook().getAppSecret());

        final DefaultFacebookClient facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), Version.LATEST);
        final FacebookClient.DebugTokenInfo debugTokenInfo = facebookClient.debugToken(login.getAccessToken());

        if (!debugTokenInfo.isValid()) {
            throw new LodomaniakSystemException("Invalid access token. Cannot sign into your account.");
        }

        return facebookClient.fetchObject(debugTokenInfo.getUserId(), User.class,
                Parameter.with("fields", "email, first_name, last_name, short_name"));
    }
}
