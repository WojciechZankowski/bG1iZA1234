package pl.lodomaniak.icecream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import pl.lodomaniak.icecream.api.FlavorActivityTO;
import pl.lodomaniak.icecream.api.FlavorTO;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface FlavorService {

    void addFlavor(FlavorTO flavor);

    void updateFlavor(FlavorTO flavor);

    Page<FlavorTO> getFlavors(User user, Pageable pageable) throws UserNotFoundException;

    Page<FlavorTO> getFlavors(String name, String city, Pageable pageable) throws UserNotFoundException;

    void scheduleFlavor(FlavorActivityTO flavorActivity);

    void updateFlavorSchedule(FlavorActivityTO flavorActivity);

    Page<FlavorActivityTO> getPlannedFlavors(final Pageable pageable, User user) throws UserNotFoundException;

    List<FlavorActivityTO> getAvailableFlavors(String city, Long flavorId, Long iceCreamShopId, LocalDate date);

    List<FlavorTO> getTopFlavors(String city);

}
