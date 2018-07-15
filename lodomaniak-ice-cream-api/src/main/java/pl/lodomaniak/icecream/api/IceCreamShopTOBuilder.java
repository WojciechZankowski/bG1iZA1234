package pl.lodomaniak.icecream.api;

import java.time.DayOfWeek;
import java.util.Map;

public final class IceCreamShopTOBuilder {
    private Long id;
    private String imageUrl;
    private CompanyTO company;
    private AddressTO address;
    private Map<DayOfWeek, OpeningHoursRangeTO> openingHours;

    public IceCreamShopTOBuilder withId(final Long id) {
        this.id = id;
        return this;
    }

    public IceCreamShopTOBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public IceCreamShopTOBuilder withCompany(CompanyTO company) {
        this.company = company;
        return this;
    }

    public IceCreamShopTOBuilder withAddress(AddressTO address) {
        this.address = address;
        return this;
    }

    public IceCreamShopTOBuilder withOpeningHours(Map<DayOfWeek, OpeningHoursRangeTO> openingHours) {
        this.openingHours = openingHours;
        return this;
    }

    public IceCreamShopTO build() {
        return new IceCreamShopTO(id, imageUrl, company, address, openingHours);
    }
}
