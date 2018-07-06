package pl.lodomaniak.icecream.mapper;

import org.springframework.stereotype.Component;
import pl.lodomaniak.icecream.api.FlavorTO;
import pl.lodomaniak.icecream.api.FlavorTOBuilder;
import pl.lodomaniak.icecream.entity.FlavorEntity;
import pl.lodomaniak.icecream.entity.FlavorEntityBuilder;

@Component
public class FlavorMapper {

    public FlavorEntity map(final FlavorTO flavor) {
        return new FlavorEntityBuilder()
                .withName(flavor.getName())
                .build();
    }

    public FlavorTO map(final FlavorEntity flavor) {
        return new FlavorTOBuilder()
                .withName(flavor.getName())
                .withImageUrl(flavor.getImageUrl())
                .build();
    }

}
