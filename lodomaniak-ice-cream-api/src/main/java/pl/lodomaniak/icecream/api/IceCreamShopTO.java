package pl.lodomaniak.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;
import pl.lodomaniak.core.ITransferObject;

import java.time.DayOfWeek;
import java.util.Map;

@JsonPropertyOrder({"id", "imageUrl", "company", "address", "openingHours"})
public class IceCreamShopTO implements ITransferObject {

    private static final long serialVersionUID = 8320758878321650308L;

    private final Long id;
    private final String imageUrl;
    private final CompanyTO company;
    private final AddressTO address;
    private final Map<DayOfWeek, OpeningHoursRangeTO> openingHours;

    @JsonCreator
    public IceCreamShopTO(
            @JsonProperty("id") final Long id,
            @JsonProperty("imageUrl") final String imageUrl,
            @JsonProperty("company") final CompanyTO company,
            @JsonProperty("address") final AddressTO address,
            @JsonProperty("openingHours") final Map<DayOfWeek, OpeningHoursRangeTO> openingHours) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.company = company;
        this.address = address;
        this.openingHours = openingHours;
    }

    public Long getId() {
        return id;
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

    public Map<DayOfWeek, OpeningHoursRangeTO> getOpeningHours() {
        return openingHours;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IceCreamShopTO that = (IceCreamShopTO) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(imageUrl, that.imageUrl) &&
                Objects.equal(company, that.company) &&
                Objects.equal(address, that.address) &&
                Objects.equal(openingHours, that.openingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, imageUrl, company, address, openingHours);
    }

    @Override
    public String toString() {
        return "IceCreamShopTO{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", company=" + company +
                ", address=" + address +
                ", openingHours=" + openingHours +
                '}';
    }
}
