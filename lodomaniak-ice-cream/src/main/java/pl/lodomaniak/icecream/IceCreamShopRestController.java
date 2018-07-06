package pl.lodomaniak.icecream;

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
import pl.lodomaniak.icecream.api.IceCreamShopTO;

@RestController
@RequestMapping("/api/icecreamshop")
@Api(tags = "Ice Cream Shop", description = "Perform operations on Ice Cream shops.")
public class IceCreamShopRestController {

    private final IceCreamShopService iceCreamShopService;

    @Autowired
    public IceCreamShopRestController(final IceCreamShopService iceCreamShopService) {
        this.iceCreamShopService = iceCreamShopService;
    }

    @ApiOperation(value = "Create Ice Cream Shop.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ice Cream Shop created")})
    @PostMapping()
    public ResponseEntity<?> addIceCreamShop(@RequestBody final IceCreamShopTO iceCreamShop) {
        iceCreamShopService.addIceCreamShop(iceCreamShop);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
