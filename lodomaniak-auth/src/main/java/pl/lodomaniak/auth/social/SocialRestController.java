package pl.lodomaniak.auth.social;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/social")
public class SocialRestController {

    private static final Logger LOG = LoggerFactory.getLogger(SocialRestController.class);

    private final SocialService socialService;
    private final ProviderSignInUtils providerSignInUtils;

    @Autowired
    public SocialRestController(final SocialService socialService, final ProviderSignInUtils providerSignInUtils) {
        this.socialService = socialService;
        this.providerSignInUtils = providerSignInUtils;
    }

    @GetMapping("/signup")
    public RedirectView signUp(final WebRequest webRequest) {
        try {
            final Connection<?> connection = providerSignInUtils.getConnectionFromSession(webRequest);
            socialService.createUser(connection);
            return new RedirectView(URIBuilder.fromUri("/#/social-register/" + connection.getKey().getProviderId())
                    .queryParam("success", "true")
                    .build().toString(), true);
        } catch (Exception e) {
            LOG.error("Exception creating social user: ", e);
            return new RedirectView(URIBuilder.fromUri("/#/social-register/no-provider")
                    .queryParam("success", "false")
                    .build().toString(), true);
        }
    }

}
