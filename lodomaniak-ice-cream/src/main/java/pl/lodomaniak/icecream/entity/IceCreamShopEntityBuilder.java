package pl.lodomaniak.icecream.entity;

import java.time.DayOfWeek;
import java.util.Map;

public final class IceCreamShopEntityBuilder {
    private Long id;
    private String imageUrl;
    private CompanyEntity company;
    private AddressEntity address;
    private Map<DayOfWeek, OpeningHoursRangeEntity> openingHours;

    public IceCreamShopEntityBuilder withId(final Long id) {
        this.id = id;
        return this;
    }

    public IceCreamShopEntityBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public IceCreamShopEntityBuilder withCompany(CompanyEntity company) {
        this.company = company;
        return this;
    }

    public IceCreamShopEntityBuilder withAddress(AddressEntity address) {
        this.address = address;
        return this;
    }

    public IceCreamShopEntityBuilder withOpeningHours(Map<DayOfWeek, OpeningHoursRangeEntity> openingHours) {
        this.openingHours = openingHours;
        return this;
    }

    public IceCreamShopEntity build() {
        return new IceCreamShopEntity(id, imageUrl, company, address, openingHours);
    }
}
