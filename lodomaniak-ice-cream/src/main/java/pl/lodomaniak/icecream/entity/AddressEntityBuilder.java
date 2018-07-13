package pl.lodomaniak.icecream.entity;

import com.neovisionaries.i18n.CountryCode;

public final class AddressEntityBuilder {
    private Long id;
    private String streetAddress;
    private String city;
    private String county;
    private String zipCode;
    private CountryCode countryCode;

    public AddressEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public AddressEntityBuilder withStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public AddressEntityBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressEntityBuilder withCounty(String county) {
        this.county = county;
        return this;
    }

    public AddressEntityBuilder withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressEntityBuilder withCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public AddressEntity build() {
        return new AddressEntity(id, streetAddress, city, county, zipCode, countryCode);
    }
}
