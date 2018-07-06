package pl.lodomaniak.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(tags = "Account", description = "Perform operations on user account.")
public class AccountRestController {

    private final UserService userService;

    @Autowired
    public AccountRestController(final UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Register user account.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User account created.")})
    @PostMapping("/register")
    public ResponseEntity registerAccount(@Valid @RequestBody final AccountTO account) {
        userService.registerAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
