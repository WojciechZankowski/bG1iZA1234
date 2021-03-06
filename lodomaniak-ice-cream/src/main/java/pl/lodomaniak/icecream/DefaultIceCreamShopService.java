package pl.lodomaniak.icecream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.icecream.entity.AddressEntity;
import pl.lodomaniak.icecream.entity.IceCreamShopEntity;
import pl.lodomaniak.icecream.entity.OpeningHoursRangeEntity;
import pl.lodomaniak.icecream.mapper.IceCreamShopMapper;
import pl.lodomaniak.rating.api.RatingTO;
import pl.lodomaniak.rating.api.RatingType;
import pl.lodomaniak.rating.spi.RatingExternalService;
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
    private final RatingExternalService ratingService;

    @Autowired
    public DefaultIceCreamShopService(final AddressRepository addressRepository,
            final CompanyRepository companyRepository, final IceCreamShopRepository iceCreamShopRepository,
            final IceCreamShopMapper iceCreamShopMapper, final OpeningHoursRangeRepository rangeRepository,
            final CompanyService companyService, final RatingExternalService ratingService) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.iceCreamShopRepository = iceCreamShopRepository;
        this.iceCreamShopMapper = iceCreamShopMapper;
        this.rangeRepository = rangeRepository;
        this.companyService = companyService;
        this.ratingService = ratingService;
    }

    @Override
    public List<String> getCities() {
        return addressRepository.findDistinctCity();
    }

    @Override
    public List<IceCreamShopTO> getLatelyAddedShops(final String city) {
        final Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "id");
        return iceCreamShopRepository.findByAddressCity(city, pageable).stream()
                .map(iceCreamShopMapper::map)
                .collect(toList());
    }

    @Override
    public void addIceCreamShop(final IceCreamShopTO iceCreamShop) {
        final IceCreamShopEntity entity = iceCreamShopMapper.map(iceCreamShop);
        save(entity.getAddress());
        iceCreamShopRepository.save(entity);
    }

    private void save(final AddressEntity entity) {
        if (entity.getId() == null) {
            addressRepository.save(entity);
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

    @Override
    public Page<IceCreamShopTO> getIceCreamShops(final String company, final String city, final Pageable pageable) {
        final String companyName = company == null ? "" : company;
        return iceCreamShopRepository.findByAddressCityAndCompanyNameContaining(city, companyName, pageable)
                .map(iceCreamShopMapper::map);
    }

    @Override
    public List<IceCreamShopTO> getTopIceCreamShops(final String city) {
        final List<Long> iceCreamShopIds = iceCreamShopRepository.findByAddressCity(city).stream()
                .map(IceCreamShopEntity::getId)
                .collect(toList());

        final List<Long> topIceCreamShopIds = ratingService.getMostPopular(RatingType.ICE_CREAM_SHOP, iceCreamShopIds).stream()
                .map(RatingTO::getRatedObjectId)
                .collect(toList());

        return iceCreamShopRepository.findAllById(topIceCreamShopIds).stream()
                .map(iceCreamShopMapper::map)
                .collect(toList());
    }
}
