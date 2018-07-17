package pl.lodomaniak.icecream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.icecream.entity.AddressEntity;
import pl.lodomaniak.icecream.entity.CompanyEntity;
import pl.lodomaniak.icecream.entity.IceCreamShopEntity;
import pl.lodomaniak.icecream.entity.OpeningHoursRangeEntity;
import pl.lodomaniak.icecream.mapper.IceCreamShopMapper;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class DefaultIceCreamShopService implements IceCreamShopService {

    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final OpeningHoursRangeRepository rangeRepository;
    private final IceCreamShopRepository iceCreamShopRepository;
    private final IceCreamShopMapper iceCreamShopMapper;
    private final CompanyService companyService;

    @Autowired
    public DefaultIceCreamShopService(final AddressRepository addressRepository,
            final CompanyRepository companyRepository, final IceCreamShopRepository iceCreamShopRepository,
            final IceCreamShopMapper iceCreamShopMapper, final OpeningHoursRangeRepository rangeRepository,
            final CompanyService companyService) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.iceCreamShopRepository = iceCreamShopRepository;
        this.iceCreamShopMapper = iceCreamShopMapper;
        this.rangeRepository = rangeRepository;
        this.companyService = companyService;
    }

    @Override
    public void addIceCreamShop(final IceCreamShopTO iceCreamShop) {
        final IceCreamShopEntity entity = iceCreamShopMapper.map(iceCreamShop);
        save(entity.getCompany());
        save(entity.getAddress());
        iceCreamShopRepository.save(entity);
    }

    private void save(final AddressEntity entity) {
        if (entity.getId() == null) {
            addressRepository.save(entity);
        }
    }

    private void save(final CompanyEntity entity) {
        if (entity.getId() == null) {
            save(entity.getAddress());
            companyRepository.save(entity);
        }
    }

    private void save(final Map<DayOfWeek, OpeningHoursRangeEntity> entityMap) {
        for (final Map.Entry<DayOfWeek, OpeningHoursRangeEntity> entry : entityMap.entrySet()) {
            if (entry.getValue() != null && entry.getValue().getId() == null) {
                rangeRepository.save(entry.getValue());
            }
        }
    }

    @Override
    public void updateIceCreamShop(final IceCreamShopTO iceCreamShop) {
        final IceCreamShopEntity entity = iceCreamShopMapper.map(iceCreamShop);
        iceCreamShopRepository.save(entity);
    }

    @Override
    public List<IceCreamShopTO> getIceCreamShops(final User user) throws UserNotFoundException {
        final List<Long> companiesId = companyService.getCompanies(user).stream()
                .map(CompanyTO::getId)
                .collect(toList());
        return iceCreamShopRepository.findAllByCompanyIdIn(companiesId).stream()
                .map(iceCreamShopMapper::map)
                .collect(toList());
    }

}
