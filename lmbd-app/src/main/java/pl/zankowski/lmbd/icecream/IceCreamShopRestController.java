package pl.zankowski.lmbd.icecream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zankowski.lmbd.icecream.api.IceCreamShopTO;

@RestController
@RequestMapping("/api/icecreamshop")
public class IceCreamShopRestController {

    private final IceCreamShopService iceCreamShopService;

    @Autowired
    public IceCreamShopRestController(final IceCreamShopService iceCreamShopService) {
        this.iceCreamShopService = iceCreamShopService;
    }

    @PostMapping()
    public ResponseEntity<?> addIceCreamShop(@RequestBody final IceCreamShopTO iceCreamShop) {
        iceCreamShopService.addIceCreamShop(iceCreamShop);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
