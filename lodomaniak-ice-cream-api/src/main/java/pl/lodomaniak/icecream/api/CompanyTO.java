package pl.lodomaniak.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;
import pl.lodomaniak.core.ITransferObject;

@JsonPropertyOrder({"name", "imageUrl", "nip", "regon", "address"})
public class CompanyTO implements ITransferObject {

    private static final long serialVersionUID = 6745744081207083605L;

    private final String name;
    private final String imageUrl;
    private final String nip;
    private final String regon;
    private final AddressTO address;

    @JsonCreator
    public CompanyTO(
            @JsonProperty("name") final String name,
            @JsonProperty("imageUrl") final String imageUrl,
            @JsonProperty("nip") final String nip,
            @JsonProperty("regon") final String regon,
            @JsonProperty("address") final AddressTO address) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.nip = nip;
        this.regon = regon;
        this.address = address;
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
        return Objects.equal(name, companyTO.name) &&
                Objects.equal(imageUrl, companyTO.imageUrl) &&
                Objects.equal(nip, companyTO.nip) &&
                Objects.equal(regon, companyTO.regon) &&
                Objects.equal(address, companyTO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, imageUrl, nip, regon, address);
    }

    @Override
    public String toString() {
        return "CompanyTO{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", address=" + address +
                '}';
    }
}
