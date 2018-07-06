package pl.lodomaniak.icecream;

import pl.lodomaniak.icecream.api.FlavorTO;

import java.util.List;

public interface FlavorService {

    void addFlavor(FlavorTO flavor);

    List<FlavorTO> getAvailableFlavors(long iceCreamShopId);

    List<FlavorTO> getFlavors(long companyId);

}
