package pl.lodomaniak.icecream.mapper;

import org.springframework.stereotype.Component;
import pl.lodomaniak.icecream.api.AddressTO;
import pl.lodomaniak.icecream.api.AddressTOBuilder;
import pl.lodomaniak.icecream.entity.AddressEntity;
import pl.lodomaniak.icecream.entity.AddressEntityBuilder;

@Component
public class AddressMapper {

    public AddressEntity map(final AddressTO address) {
        return new AddressEntityBuilder()
                .withStreetAddress(address.getStreetAddress())
                .withCity(address.getCity())
                .withCounty(address.getCounty())
                .withZipCode(address.getZipCode())
                .withCountryCode(address.getCountryCode())
                .build();
    }

    public AddressTO map(final AddressEntity entity) {
        return new AddressTOBuilder()
                .withStreetAddress(entity.getStreetAddress())
                .withZipCode(entity.getZipCode())
                .withCounty(entity.getCounty())
                .withCountryCode(entity.getCountryCode())
                .withCity(entity.getCity())
                .build();
    }

}
