package pl.zankowski.lmbd.icecream;

import pl.zankowski.lmbd.icecream.api.FlavorTO;

import java.util.List;

public interface FlavorService {

    void addFlavor(FlavorTO flavor);

    List<FlavorTO> getAvailableFlavors(long iceCreamShopId);

    List<FlavorTO> getFlavors(long companyId);

}
