package pl.lodomaniak.icecream.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodomaniak.icecream.api.FlavorActivityTO;
import pl.lodomaniak.icecream.api.FlavorActivityTOBuilder;
import pl.lodomaniak.icecream.entity.FlavorActivityEntity;
import pl.lodomaniak.icecream.entity.FlavorActivityEntityBuilder;
import pl.lodomaniak.icecream.entity.FlavorEntity;
import pl.lodomaniak.icecream.entity.FlavorEntityBuilder;

@Component
public class FlavorActivityMapper {

    private final FlavorMapper flavorMapper;
    private final IceCreamShopMapper iceCreamShopMapper;

    @Autowired
    public FlavorActivityMapper(final FlavorMapper flavorMapper, final IceCreamShopMapper iceCreamShopMapper) {
        this.flavorMapper = flavorMapper;
        this.iceCreamShopMapper = iceCreamShopMapper;
    }

    public FlavorActivityTO map(final FlavorActivityEntity entity) {
        return new FlavorActivityTOBuilder()
                .withId(entity.getId())
                .withDate(entity.getDate())
                .withFlavor(flavorMapper.map(entity.getFlavor()))
                .withIceCreamShop(iceCreamShopMapper.map(entity.getIceCreamShop()))
                .build();
    }

    public FlavorActivityEntity map(final FlavorActivityTO activity) {
        return new FlavorActivityEntityBuilder()
                .withId(activity.getId())
                .withDate(activity.getDate())
                .withFlavor(flavorMapper.map(activity.getFlavor()))
                .withIceCreamShop(iceCreamShopMapper.map(activity.getIceCreamShop()))
                .build();
    }

}
