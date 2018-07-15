package pl.lodomaniak.icecream;

import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.icecream.api.FlavorTO;

import java.util.List;

public interface FlavorService {

    void addFlavor(FlavorTO flavor);

    void updateFlavor(FlavorTO flavor);

    List<FlavorTO> getAvailableFlavors(long iceCreamShopId);

    List<FlavorTO> getFlavors(User user);

}
