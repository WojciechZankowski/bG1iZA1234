package pl.zankowski.lmbd.icecream.entity;

import java.time.LocalDate;

public final class FlavorActivityEntityBuilder {
    private LocalDate date;
    private FlavorEntity flavor;
    private IceCreamShopEntity iceCreamShop;

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
        return new FlavorActivityEntity(date, flavor, iceCreamShop);
    }
}
