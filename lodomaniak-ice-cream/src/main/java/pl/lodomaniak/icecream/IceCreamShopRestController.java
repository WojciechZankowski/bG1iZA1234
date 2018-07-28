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
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

@RestController
@RequestMapping("/api/icecreamshop")
@Api(tags = "Ice Cream Shop", description = "Perform operations on Ice Cream shops.")
public class IceCreamShopRestController {

    private final IceCreamShopService iceCreamShopService;

    @Autowired
    public IceCreamShopRestController(final IceCreamShopService iceCreamShopService) {
        this.iceCreamShopService = iceCreamShopService;
    }

    @ApiOperation(value = "Get list of cities where Ice Cream Shops are")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of cities retrieved")})
    @GetMapping("/cities")
    public ResponseEntity<?> getCities() {
        return ResponseEntity.ok(iceCreamShopService.getCities());
    }

    @ApiOperation(value = "Get list of lately added Ice Cream Shops in the city")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of lately added shops retrieved")})
    @GetMapping("/last")
    public ResponseEntity<?> getLatelyAdded(@RequestParam final String city) {
        return ResponseEntity.ok(iceCreamShopService.getLatelyAddedShops(city));
    }

    @ApiOperation(value = "Get list of Ice Cream Shops in the city with given name.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of shops in the city and give name retrieved")})
    @GetMapping
    public ResponseEntity<?> getIceCreamShops(@RequestParam(required = false) final String name, @RequestParam final String city,
            final Pageable pageable) {
        return ResponseEntity.ok(iceCreamShopService.getIceCreamShops(name, city, pageable));
    }

    @ApiOperation(value = "Create Ice Cream Shop.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ice Cream Shop created")})
    @PostMapping
    public ResponseEntity<?> addIceCreamShop(@RequestBody final IceCreamShopTO iceCreamShop) {
        iceCreamShopService.addIceCreamShop(iceCreamShop);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Update Ice Cream Shop.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ice Cream Shop updated")})
    @PutMapping
    public ResponseEntity<?> updateIceCreamShop(@RequestBody final IceCreamShopTO iceCreamShop) {
        iceCreamShopService.updateIceCreamShop(iceCreamShop);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Ice Cream Shop retrieval.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ice Cream Shop received")})
    @GetMapping("/mine")
    public ResponseEntity<?> getIceCreamShops(@AuthenticationPrincipal final User user) throws UserNotFoundException {
        return ResponseEntity.ok(iceCreamShopService.getIceCreamShops(user));
    }

}
