package pl.lodomaniak.rating;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

@RestController
@RequestMapping("/api/rating")
@Api(tags = "Rating", description = "Perform operations on ratings.")
public class RatingRestController {

    private final RatingService ratingService;

    @Autowired
    public RatingRestController(final RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @ApiOperation(value = "Add rating.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Rating added.")})
    @PostMapping
    public ResponseEntity<?> addRating(final RatingTO rating, @AuthenticationPrincipal final User user)
            throws UserNotFoundException {
        ratingService.addRating(rating, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Remove rating.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Rating removed.")})
    @DeleteMapping
    public ResponseEntity<?> removeRating(final RatingTO rating, @AuthenticationPrincipal final User user)
            throws UserNotFoundException {
        ratingService.removeRating(rating, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
