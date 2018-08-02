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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingType;
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

    @ApiOperation(value = "Get mine rating.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "My rating received.")})
    @GetMapping("/mine")
    public ResponseEntity<?> getRating(@RequestParam final Long ratedObjectId, @RequestParam final RatingType ratingType,
            @AuthenticationPrincipal final User user) throws UserNotFoundException {
        return ResponseEntity.ok(ratingService.getRating(ratingType, ratedObjectId, user));
    }

    @ApiOperation(value = "Add rating.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Rating added.")})
    @PostMapping
    public ResponseEntity<?> addRating(@RequestBody final RatingTO rating, @AuthenticationPrincipal final User user)
            throws UserNotFoundException {
        final RatingTO savedRating = ratingService.addRating(rating, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @ApiOperation(value = "Remove rating.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Rating removed.")})
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<?> removeRating(@PathVariable final Long ratingId, @AuthenticationPrincipal final User user)
            throws UserNotFoundException {
        ratingService.removeRating(ratingId, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
