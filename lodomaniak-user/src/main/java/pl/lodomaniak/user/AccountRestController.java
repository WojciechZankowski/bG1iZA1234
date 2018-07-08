package pl.lodomaniak.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lodomaniak.user.api.AccountTO;
import pl.lodomaniak.user.api.PasswordResetRequestTO;
import pl.lodomaniak.user.api.PasswordResetTO;
import pl.lodomaniak.user.api.UserTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;
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

    @ApiOperation(value = "Activate user account.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User account activated.")})
    @GetMapping("/activate")
    public ResponseEntity activateAccount(@RequestParam final String key) throws UserNotFoundException {
        return ResponseEntity.ok(userService.activateAccount(key));
    }

    @ApiOperation(value = "Get currently logged in user account.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User account retrieved.")})
    @GetMapping("/account")
    public ResponseEntity<UserTO> getAccount() throws UserNotFoundException {
        return ResponseEntity.ok(userService.getAccount());
    }

    @ApiOperation(value = "Send password reset email for given user.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Password reset email has been sent.")})
    @PostMapping("/account/password-reset/init")
    public ResponseEntity initPasswordReset(@RequestBody final PasswordResetRequestTO request) throws UserNotFoundException {
        userService.initPasswordReset(request);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Reset password for an user.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Password has been reset.")})
    @PostMapping("/account/password-reset")
    public ResponseEntity resetPassword(@RequestBody final PasswordResetTO passwordReset) throws UserNotFoundException {
        userService.resetPassword(passwordReset);
        return ResponseEntity.ok().build();
    }

}
