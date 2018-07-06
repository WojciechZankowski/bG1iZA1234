package pl.lodomaniak.icecream.mapper;

import org.springframework.stereotype.Component;
import pl.lodomaniak.icecream.api.AddressTO;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.api.IceCreamShopTO;
import pl.lodomaniak.icecream.api.OpeningHoursRangeTO;
import pl.lodomaniak.icecream.api.OpeningHoursTO;
import pl.lodomaniak.icecream.entity.AddressEntity;
import pl.lodomaniak.icecream.entity.AddressEntityBuilder;
import pl.lodomaniak.icecream.entity.CompanyEntity;
import pl.lodomaniak.icecream.entity.CompanyEntityBuilder;
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

    public IceCreamShopEntity map(final IceCreamShopTO iceCreamShop) {
        return new IceCreamShopEntityBuilder()
                .withImageUrl(iceCreamShop.getImageUrl())
                .withAddress(map(iceCreamShop.getAddress()))
                .withCompany(map(iceCreamShop.getCompany()))
                .withOpeningHours(map(iceCreamShop.getOpeningHours()))
                .build();
    }

    private AddressEntity map(final AddressTO address) {
        return new AddressEntityBuilder()
                .withStreetAddress(address.getStreetAddress())
                .withCity(address.getCity())
                .withCounty(address.getCounty())
                .withZipCode(address.getZipCode())
                .withCountryCode(address.getCountryCode())
                .build();
    }

    private CompanyEntity map(final CompanyTO company) {
        return new CompanyEntityBuilder()
                .withAddressEntity(map(company.getAddress()))
                .withImageUrl(company.getImageUrl())
                .withName(company.getName())
                .withNip(company.getNip())
                .withRegon(company.getRegon())
                .build();
    }

    private OpeningHoursEntity map(final OpeningHoursTO openingHours) {
        final Map<DayOfWeek, OpeningHoursRangeEntity> mappedOpeningHours = openingHours.getOpeningHours()
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, (entry) -> map(entry.getValue())));

        return new OpeningHoursEntityBuilder()
                .withOpeningHours(mappedOpeningHours)
                .build();
    }

    private OpeningHoursRangeEntity map(final OpeningHoursRangeTO openingHoursRange) {
        return new OpeningHoursRangeEntityBuilder()
                .withOpenHour(openingHoursRange.getOpenHour())
                .withCloseHour(openingHoursRange.getCloseHour())
                .build();
    }

}
