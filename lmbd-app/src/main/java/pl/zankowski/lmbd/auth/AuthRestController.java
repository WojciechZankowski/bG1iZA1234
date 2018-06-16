package pl.zankowski.lmbd.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zankowski.lmbd.auth.api.LoginTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthRestController {

    private final AuthService authService;

    @Autowired
    public AuthRestController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticate(@Valid @RequestBody final LoginTO login) {
        return ResponseEntity.ok(authService.createAuthToken(login));
    }

}
