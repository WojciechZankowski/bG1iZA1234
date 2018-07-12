package pl.lodomaniak.icecream.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodomaniak.icecream.api.CompanyTO;
import pl.lodomaniak.icecream.api.CompanyTOBuilder;
import pl.lodomaniak.icecream.entity.CompanyEntity;
import pl.lodomaniak.icecream.entity.CompanyEntityBuilder;

@Component
public class CompanyMapper {

    private final AddressMapper addressMapper;

    @Autowired
    public CompanyMapper(final AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CompanyEntity map(final CompanyTO company) {
        return new CompanyEntityBuilder()
                .withAddressEntity(addressMapper.map(company.getAddress()))
                .withImageUrl(company.getImageUrl())
                .withName(company.getName())
                .withNip(company.getNip())
                .withRegon(company.getRegon())
                .build();
    }

    public CompanyTO map(final CompanyEntity entity) {
        return new CompanyTOBuilder()
                .withAddress(addressMapper.map(entity.getAddressEntity()))
                .withName(entity.getName())
                .withRegon(entity.getRegon())
                .withNip(entity.getNip())
                .withImageUrl(entity.getImageUrl())
                .build();
    }

}
