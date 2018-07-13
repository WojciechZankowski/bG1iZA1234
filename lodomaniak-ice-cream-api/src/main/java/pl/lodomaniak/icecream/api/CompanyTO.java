package pl.lodomaniak.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.lodomaniak.core.ITransferObject;

import java.util.Objects;

@JsonPropertyOrder({"id", "name", "imageUrl", "nip", "regon", "address"})
public class CompanyTO implements ITransferObject {

    private static final long serialVersionUID = 6745744081207083605L;

    private final Long id;
    private final String name;
    private final String imageUrl;
    private final String nip;
    private final String regon;
    private final AddressTO address;

    @JsonCreator
    public CompanyTO(
            @JsonProperty("id") final Long id,
            @JsonProperty("name") final String name,
            @JsonProperty("imageUrl") final String imageUrl,
            @JsonProperty("nip") final String nip,
            @JsonProperty("regon") final String regon,
            @JsonProperty("address") final AddressTO address) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.nip = nip;
        this.regon = regon;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public AddressTO getAddress() {
        return address;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CompanyTO companyTO = (CompanyTO) o;
        return Objects.equals(id, companyTO.id) &&
                Objects.equals(name, companyTO.name) &&
                Objects.equals(imageUrl, companyTO.imageUrl) &&
                Objects.equals(nip, companyTO.nip) &&
                Objects.equals(regon, companyTO.regon) &&
                Objects.equals(address, companyTO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUrl, nip, regon, address);
    }

    @Override
    public String toString() {
        return "CompanyTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", address=" + address +
                '}';
    }
}
