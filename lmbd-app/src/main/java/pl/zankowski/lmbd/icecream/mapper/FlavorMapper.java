package pl.zankowski.lmbd.icecream.mapper;

import org.springframework.stereotype.Component;
import pl.zankowski.lmbd.icecream.api.FlavorTO;
import pl.zankowski.lmbd.icecream.api.FlavorTOBuilder;
import pl.zankowski.lmbd.icecream.entity.FlavorEntity;
import pl.zankowski.lmbd.icecream.entity.FlavorEntityBuilder;

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
