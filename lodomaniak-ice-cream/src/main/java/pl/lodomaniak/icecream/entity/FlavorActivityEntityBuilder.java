package pl.lodomaniak.icecream.entity;

import java.time.LocalDate;

public final class FlavorActivityEntityBuilder {
    private Long id;
    private LocalDate date;
    private FlavorEntity flavor;
    private IceCreamShopEntity iceCreamShop;

    public FlavorActivityEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FlavorActivityEntityBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public FlavorActivityEntityBuilder withFlavor(FlavorEntity flavor) {
        this.flavor = flavor;
        return this;
    }

    public FlavorActivityEntityBuilder withIceCreamShop(IceCreamShopEntity iceCreamShop) {
        this.iceCreamShop = iceCreamShop;
        return this;
    }

    public FlavorActivityEntity build() {
        return new FlavorActivityEntity(id, date, flavor, iceCreamShop);
    }
}
