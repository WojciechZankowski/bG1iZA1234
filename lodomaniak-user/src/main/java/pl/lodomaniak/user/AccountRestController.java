package pl.lodomaniak.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.spi.UserService;

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
