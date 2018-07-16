package pl.lodomaniak.icecream.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodomaniak.icecream.api.FlavorTO;
import pl.lodomaniak.icecream.api.FlavorTOBuilder;
import pl.lodomaniak.icecream.entity.FlavorEntity;
import pl.lodomaniak.icecream.entity.FlavorEntityBuilder;

@Component
public class FlavorMapper {

    private final CompanyMapper companyMapper;

    @Autowired
    public FlavorMapper(final CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    public FlavorEntity map(final FlavorTO flavor) {
        return new FlavorEntityBuilder()
                .withId(flavor.getId())
                .withName(flavor.getName())
                .withImageUrl(flavor.getImageUrl())
                .withTags(flavor.getTags())
                .withCompany(companyMapper.map(flavor.getCompany()))
                .build();
    }

    public FlavorTO map(final FlavorEntity flavor) {
        return new FlavorTOBuilder()
                .withId(flavor.getId())
                .withName(flavor.getName())
                .withImageUrl(flavor.getImageUrl())
                .withTags(flavor.getTags())
                .withCompany(companyMapper.map(flavor.getCompany()))
                .build();
    }

}
