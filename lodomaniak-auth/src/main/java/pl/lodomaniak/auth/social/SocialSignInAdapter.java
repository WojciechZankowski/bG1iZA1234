package pl.lodomaniak.auth.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import pl.lodomaniak.auth.jwt.TokenProvider;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;

import javax.servlet.http.Cookie;

@Component
public class SocialSignInAdapter implements SignInAdapter {

    private final UserDetailsService userDetailsService;
    private final TokenProvider tokenProvider;
    private final LodomaniakConfigurationProperties properties;

    @Autowired
    public SocialSignInAdapter(final UserDetailsService userDetailsService, final TokenProvider tokenProvider,
            final LodomaniakConfigurationProperties properties) {
        this.userDetailsService = userDetailsService;
        this.tokenProvider = tokenProvider;
        this.properties = properties;
    }

    @Override
    public String signIn(final String userId, final Connection<?> connection, final NativeWebRequest request) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        final String token = tokenProvider.createAuthToken(authenticationToken, false);

        final ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        servletWebRequest.getResponse().addCookie(getSocialAuthenticationCookie(token));

        return properties.getSocial().getRedirectAfterSignIn();
    }

    private Cookie getSocialAuthenticationCookie(String token) {
        final Cookie socialAuthCookie = new Cookie("social-authentication", token);
        socialAuthCookie.setPath("/");
        socialAuthCookie.setMaxAge(10);
        return socialAuthCookie;
    }

}
