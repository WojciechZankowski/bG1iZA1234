package pl.lodomaniak.icecream;

import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

import java.util.List;

public interface IceCreamShopService {

    void addIceCreamShop(IceCreamShopTO iceCreamShop);

    void updateIceCreamShop(IceCreamShopTO iceCreamShop);

    List<IceCreamShopTO> getIceCreamShops(User user) throws UserNotFoundException;

}
