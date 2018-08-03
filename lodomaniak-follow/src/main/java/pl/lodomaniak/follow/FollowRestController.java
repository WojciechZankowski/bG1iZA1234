package pl.lodomaniak.follow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lodomaniak.follow.api.FollowTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

@RestController
@RequestMapping("/api/follow")
@Api(tags = "Follow", description = "Perform operations on follows.")
public class FollowRestController {

    private final FollowService followService;

    @Autowired
    public FollowRestController(final FollowService followService) {
        this.followService = followService;
    }

    @ApiOperation(value = "Add follow.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Follow added.")})
    @PostMapping
    public ResponseEntity<?> addRating(@RequestBody final FollowTO follow, @AuthenticationPrincipal final User user)
            throws UserNotFoundException {
        final FollowTO savedFollow = followService.addFollow(follow, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFollow);
    }

    @ApiOperation(value = "Remove follow.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Follow removed.")})
    @DeleteMapping("/{followId}")
    public ResponseEntity<?> removeRating(@PathVariable final Long followId, @AuthenticationPrincipal final User user)
            throws UserNotFoundException {
        followService.removeFollow(followId, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
