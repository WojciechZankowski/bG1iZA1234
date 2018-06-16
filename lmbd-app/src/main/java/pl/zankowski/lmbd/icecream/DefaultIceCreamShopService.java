package pl.zankowski.lmbd.icecream;

import org.springframework.stereotype.Service;
import pl.zankowski.lmbd.icecream.api.IceCreamShopTO;
import pl.zankowski.lmbd.icecream.mapper.IceCreamShopMapper;

@Service
public class DefaultIceCreamShopService implements IceCreamShopService {

    private final IceCreamShopRepository iceCreamShopRepository;
    private final IceCreamShopMapper iceCreamShopMapper;

    public DefaultIceCreamShopService(final IceCreamShopRepository iceCreamShopRepository,
            final IceCreamShopMapper iceCreamShopMapper) {
        this.iceCreamShopRepository = iceCreamShopRepository;
        this.iceCreamShopMapper = iceCreamShopMapper;
    }

    @Override
    public void addIceCreamShop(final IceCreamShopTO iceCreamShop) {
        iceCreamShopRepository.save(iceCreamShopMapper.map(iceCreamShop));
    }

}
