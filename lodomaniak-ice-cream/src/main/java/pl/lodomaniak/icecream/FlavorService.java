package pl.lodomaniak.icecream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.icecream.api.FlavorActivityTO;
import pl.lodomaniak.icecream.api.FlavorTO;

import java.util.List;

public interface FlavorService {

    void addFlavor(FlavorTO flavor);

    void updateFlavor(FlavorTO flavor);

    List<FlavorTO> getAvailableFlavors(long iceCreamShopId);

    List<FlavorTO> getFlavors(User user);

    void scheduleFlavor(FlavorActivityTO flavorActivity);

    void updateFlavorSchedule(FlavorActivityTO flavorActivity);

    Page<FlavorActivityTO> getPlannedFlavors(final Pageable pageable, User user);

}
