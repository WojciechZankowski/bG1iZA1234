package pl.lodomaniak.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;
import pl.lodomaniak.core.ITransferObject;

import java.util.List;

@JsonPropertyOrder({"imageUrl", "company", "address", "openingHours"})
public class IceCreamShopTO implements ITransferObject {

    private static final long serialVersionUID = 8320758878321650308L;

    private final String imageUrl;
    private final CompanyTO company;
    private final AddressTO address;
    private final OpeningHoursTO openingHours;

    @JsonCreator
    public IceCreamShopTO(
            @JsonProperty("imageUrl") final String imageUrl,
            @JsonProperty("company") final CompanyTO company,
            @JsonProperty("address") final AddressTO address,
            @JsonProperty("openingHours") final OpeningHoursTO openingHours) {
        this.imageUrl = imageUrl;
        this.company = company;
        this.address = address;
        this.openingHours = openingHours;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CompanyTO getCompany() {
        return company;
    }

    public AddressTO getAddress() {
        return address;
    }

    public OpeningHoursTO getOpeningHours() {
        return openingHours;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IceCreamShopTO that = (IceCreamShopTO) o;
        return Objects.equal(imageUrl, that.imageUrl) &&
                Objects.equal(company, that.company) &&
                Objects.equal(address, that.address) &&
                Objects.equal(openingHours, that.openingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(imageUrl, company, address, openingHours);
    }

    @Override
    public String toString() {
        return "IceCreamShopTO{" +
                "imageUrl='" + imageUrl + '\'' +
                ", company=" + company +
                ", address=" + address +
                ", openingHours=" + openingHours +
                '}';
    }
}
