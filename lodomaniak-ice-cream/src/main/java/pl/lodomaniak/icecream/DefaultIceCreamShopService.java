package pl.lodomaniak.icecream;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.icecream.mapper.IceCreamShopMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    @Override
    public List<IceCreamShopTO> getIceCreamShops(final User user) {
        return iceCreamShopRepository.findAll().stream()
                .map(iceCreamShopMapper::map)
                .collect(toList());
    }

}
