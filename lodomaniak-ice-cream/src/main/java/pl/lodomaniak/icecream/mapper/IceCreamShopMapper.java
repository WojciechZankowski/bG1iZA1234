package pl.lodomaniak.icecream.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.icecream.api.IceCreamShopTOBuilder;
import pl.lodomaniak.icecream.api.OpeningHoursRangeTO;
import pl.lodomaniak.icecream.api.OpeningHoursRangeTOBuilder;
import pl.lodomaniak.icecream.api.OpeningHoursTO;
import pl.lodomaniak.icecream.api.OpeningHoursTOBuilder;
import pl.lodomaniak.icecream.entity.IceCreamShopEntity;
import pl.lodomaniak.icecream.entity.IceCreamShopEntityBuilder;
import pl.lodomaniak.icecream.entity.OpeningHoursEntity;
import pl.lodomaniak.icecream.entity.OpeningHoursEntityBuilder;
import pl.lodomaniak.icecream.entity.OpeningHoursRangeEntity;
import pl.lodomaniak.icecream.entity.OpeningHoursRangeEntityBuilder;

import java.time.DayOfWeek;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class IceCreamShopMapper {

    private final AddressMapper addressMapper;
    private final CompanyMapper companyMapper;

    @Autowired
    public IceCreamShopMapper(final AddressMapper addressMapper, final CompanyMapper companyMapper) {
        this.addressMapper = addressMapper;
        this.companyMapper = companyMapper;
    }

    public IceCreamShopEntity map(final IceCreamShopTO iceCreamShop) {
        return new IceCreamShopEntityBuilder()
                .withImageUrl(iceCreamShop.getImageUrl())
                .withAddress(addressMapper.map(iceCreamShop.getAddress()))
                .withCompany(companyMapper.map(iceCreamShop.getCompany()))
                .withOpeningHours(map(iceCreamShop.getOpeningHours()))
                .build();
    }

    private OpeningHoursEntity map(final OpeningHoursTO openingHours) {
        return new OpeningHoursEntityBuilder()
                .withOpeningHours(mapTO(openingHours.getOpeningHours()))
                .build();
    }

    private Map<DayOfWeek, OpeningHoursRangeEntity> mapTO(final Map<DayOfWeek, OpeningHoursRangeTO> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, (entry) -> map(entry.getValue())));
    }

    private OpeningHoursRangeEntity map(final OpeningHoursRangeTO openingHoursRange) {
        return new OpeningHoursRangeEntityBuilder()
                .withOpenHour(openingHoursRange.getOpenHour())
                .withCloseHour(openingHoursRange.getCloseHour())
                .build();
    }

    public IceCreamShopTO map(final IceCreamShopEntity entity) {
        return new IceCreamShopTOBuilder()
                .withAddress(addressMapper.map(entity.getAddress()))
                .withCompany(companyMapper.map(entity.getCompany()))
                .withImageUrl(entity.getImageUrl())
                .withOpeningHours(map(entity.getOpeningHours()))
                .build();
    }

    private OpeningHoursTO map(final OpeningHoursEntity entity) {
        return new OpeningHoursTOBuilder()
                .withOpeningHours(map(entity.getOpeningHours()))
                .build();
    }

    private Map<DayOfWeek, OpeningHoursRangeTO> map(final Map<DayOfWeek, OpeningHoursRangeEntity> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, (entry) -> map(entry.getValue())));
    }

    private OpeningHoursRangeTO map(final OpeningHoursRangeEntity entity) {
        return new OpeningHoursRangeTOBuilder()
                .withOpenHour(entity.getOpenHour())
                .withCloseHour(entity.getCloseHour())
                .build();
    }

}
