package pl.zankowski.lmbd.icecream.mapper;

import org.springframework.stereotype.Component;
import pl.zankowski.lmbd.icecream.api.AddressTO;
import pl.zankowski.lmbd.icecream.api.CompanyTO;
import pl.zankowski.lmbd.icecream.api.IceCreamShopTO;
import pl.zankowski.lmbd.icecream.api.OpeningHoursRangeTO;
import pl.zankowski.lmbd.icecream.api.OpeningHoursTO;
import pl.zankowski.lmbd.icecream.entity.AddressEntity;
import pl.zankowski.lmbd.icecream.entity.AddressEntityBuilder;
import pl.zankowski.lmbd.icecream.entity.CompanyEntity;
import pl.zankowski.lmbd.icecream.entity.CompanyEntityBuilder;
import pl.zankowski.lmbd.icecream.entity.IceCreamShopEntity;
import pl.zankowski.lmbd.icecream.entity.IceCreamShopEntityBuilder;
import pl.zankowski.lmbd.icecream.entity.OpeningHoursEntity;
import pl.zankowski.lmbd.icecream.entity.OpeningHoursEntityBuilder;
import pl.zankowski.lmbd.icecream.entity.OpeningHoursRangeEntity;
import pl.zankowski.lmbd.icecream.entity.OpeningHoursRangeEntityBuilder;

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
