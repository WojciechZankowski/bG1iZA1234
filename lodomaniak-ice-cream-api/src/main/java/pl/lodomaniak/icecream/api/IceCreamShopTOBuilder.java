package pl.lodomaniak.icecream.api;

public final class IceCreamShopTOBuilder {
    private String imageUrl;
    private CompanyTO company;
    private AddressTO address;
    private OpeningHoursTO openingHours;

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

    public IceCreamShopTOBuilder withOpeningHours(OpeningHoursTO openingHours) {
        this.openingHours = openingHours;
        return this;
    }

    public IceCreamShopTO build() {
        return new IceCreamShopTO(imageUrl, company, address, openingHours);
    }
}
