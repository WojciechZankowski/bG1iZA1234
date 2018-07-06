package pl.lodomaniak.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;
import com.neovisionaries.i18n.CountryCode;
import pl.lodomaniak.core.ITransferObject;

@JsonPropertyOrder({"streetAddress", "city", "county", "zipCode", "countryCode"})
public class AddressTO implements ITransferObject {

    private static final long serialVersionUID = 3412163320810220011L;

    private final String streetAddress;
    private final String city;
    private final String county;
    private final String zipCode;
    private final CountryCode countryCode;

    @JsonCreator
    public AddressTO(
            @JsonProperty("streetAddress") final String streetAddress,
            @JsonProperty("city") final String city,
            @JsonProperty("county") final String county,
            @JsonProperty("zipCode") final String zipCode,
            @JsonProperty("countryCode") final CountryCode countryCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.county = county;
        this.zipCode = zipCode;
        this.countryCode = countryCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getZipCode() {
        return zipCode;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AddressTO addressTO = (AddressTO) o;
        return Objects.equal(streetAddress, addressTO.streetAddress) &&
                Objects.equal(city, addressTO.city) &&
                Objects.equal(county, addressTO.county) &&
                Objects.equal(zipCode, addressTO.zipCode) &&
                countryCode == addressTO.countryCode;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(streetAddress, city, county, zipCode, countryCode);
    }

    @Override
    public String toString() {
        return "AddressTO{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", countryCode=" + countryCode +
                '}';
    }
}
