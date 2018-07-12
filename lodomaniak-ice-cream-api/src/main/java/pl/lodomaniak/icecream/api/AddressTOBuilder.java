package pl.lodomaniak.icecream.api;

import com.neovisionaries.i18n.CountryCode;

public final class AddressTOBuilder {
    private String streetAddress;
    private String city;
    private String county;
    private String zipCode;
    private CountryCode countryCode;

    public AddressTOBuilder withStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public AddressTOBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressTOBuilder withCounty(String county) {
        this.county = county;
        return this;
    }

    public AddressTOBuilder withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressTOBuilder withCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public AddressTO build() {
        return new AddressTO(streetAddress, city, county, zipCode, countryCode);
    }
}
