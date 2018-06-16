package pl.zankowski.lmbd.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zankowski.lmbd.user.api.AccountTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final UserService userService;

    @Autowired
    public AccountRestController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerAccount(@Valid @RequestBody final AccountTO account) {
        userService.registerAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
