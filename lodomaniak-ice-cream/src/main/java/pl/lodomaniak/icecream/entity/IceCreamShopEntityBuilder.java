package pl.lodomaniak.icecream.entity;

public final class IceCreamShopEntityBuilder {
    private String imageUrl;
    private CompanyEntity company;
    private AddressEntity address;
    private OpeningHoursEntity openingHours;

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

    public IceCreamShopEntityBuilder withOpeningHours(OpeningHoursEntity openingHours) {
        this.openingHours = openingHours;
        return this;
    }

    public IceCreamShopEntity build() {
        return new IceCreamShopEntity(imageUrl, company, address, openingHours);
    }
}
