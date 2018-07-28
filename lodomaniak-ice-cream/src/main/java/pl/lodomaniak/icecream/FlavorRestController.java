package pl.lodomaniak.icecream;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lodomaniak.icecream.api.FlavorActivityTO;
import pl.lodomaniak.icecream.api.FlavorTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/flavor")
@Api(tags = "Ice Cream Flavors", description = "Perform operations on Ice Cream flavors.")
public class FlavorRestController {

    private final FlavorService flavorService;

    @Autowired
    public FlavorRestController(final FlavorService flavorService) {
        this.flavorService = flavorService;
    }

    @ApiOperation(value = "Ice Cream flavor for given city retrieval.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ice Cream flavor for city received")})
    @GetMapping
    public ResponseEntity<?> getFlavorsForCity(@RequestParam(required = false) final String name, @RequestParam final String city,
            final Pageable pageable) throws UserNotFoundException {
        return ResponseEntity.ok(flavorService.getFlavors(name, city, pageable));
    }

    @ApiOperation(value = "Create Ice Cream flavor.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ice Cream flavor created")})
    @PostMapping
    public ResponseEntity<?> addFlavor(@RequestBody final FlavorTO flavor) {
        flavorService.addFlavor(flavor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Update Ice Cream flavor.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ice Cream flavor updated.")})
    @PutMapping
    public ResponseEntity<?> updateFlavor(@RequestBody final FlavorTO flavor) {
        flavorService.updateFlavor(flavor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Ice Cream flavor retrieval.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ice Cream flavor received")})
    @GetMapping("/mine")
    public ResponseEntity<?> getFlavors(final Pageable pageable, @AuthenticationPrincipal final User user)
            throws UserNotFoundException {
        return ResponseEntity.ok(flavorService.getFlavors(user, pageable));
    }

    @ApiOperation(value = "Scheduled Ice Cream flavors retrieval.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Scheduled Ice Cream flavors received")})
    @GetMapping("/schedule")
    public ResponseEntity<?> getScheduled(final Pageable pageable, @AuthenticationPrincipal final User user)
            throws UserNotFoundException {
        return ResponseEntity.ok(flavorService.getPlannedFlavors(pageable, user));
    }

    @ApiOperation(value = "Today scheduled Ice Cream flavors in the city retrieval.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Today's flavor in the city retrieved")})
    @GetMapping("/schedule/today")
    public ResponseEntity<?> getScheduledTodayInCity(@RequestParam(required = false) final String city,
            @RequestParam(required = false) final Long flavorId, @RequestParam(required = false) final Long iceCreamShopId) {
        return ResponseEntity.ok(flavorService.getAvailableFlavors(city, flavorId, iceCreamShopId, LocalDate.now()));
    }

    @ApiOperation(value = "Schedule Ice Cream flavor.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ice Cream flavor scheduled.")})
    @PostMapping("/schedule")
    public ResponseEntity<?> scheduleFlavor(@RequestBody final FlavorActivityTO flavorActivity) {
        flavorService.scheduleFlavor(flavorActivity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Update Ice Cream flavor schedule.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ice Cream flavor schedule updated.")})
    @PutMapping("/schedule")
    public ResponseEntity<?> updateFlavorSchedule(@RequestBody final FlavorActivityTO flavorActivity) {
        flavorService.updateFlavorSchedule(flavorActivity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
