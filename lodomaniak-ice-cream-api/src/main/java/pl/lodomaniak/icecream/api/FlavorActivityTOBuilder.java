package pl.lodomaniak.icecream.api;

import java.time.LocalDate;

public final class FlavorActivityTOBuilder {
    private Long id;
    private LocalDate date;
    private FlavorTO flavor;
    private IceCreamShopTO iceCreamShop;

    public FlavorActivityTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FlavorActivityTOBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public FlavorActivityTOBuilder withFlavor(FlavorTO flavor) {
        this.flavor = flavor;
        return this;
    }

    public FlavorActivityTOBuilder withIceCreamShop(IceCreamShopTO iceCreamShop) {
        this.iceCreamShop = iceCreamShop;
        return this;
    }

    public FlavorActivityTO build() {
        return new FlavorActivityTO(id, date, flavor, iceCreamShop);
    }
}
