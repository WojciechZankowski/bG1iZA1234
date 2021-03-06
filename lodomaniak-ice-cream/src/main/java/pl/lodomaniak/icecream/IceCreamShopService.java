package pl.lodomaniak.icecream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

import java.util.List;

public interface IceCreamShopService {

    List<String> getCities();

    List<IceCreamShopTO> getLatelyAddedShops(String city);

    void addIceCreamShop(IceCreamShopTO iceCreamShop);

    void updateIceCreamShop(IceCreamShopTO iceCreamShop);

    List<IceCreamShopTO> getIceCreamShops(User user) throws UserNotFoundException;

    Page<IceCreamShopTO> getIceCreamShops(String company, String city, Pageable pageable);

    List<IceCreamShopTO> getTopIceCreamShops(String city);
}
