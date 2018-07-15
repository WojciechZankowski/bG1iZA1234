package pl.lodomaniak.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.lodomaniak.core.ITransferObject;

import java.util.Objects;

@JsonPropertyOrder({"id", "name", "imageUrl", "company"})
public class FlavorTO implements ITransferObject {

    private static final long serialVersionUID = -4066707497502285434L;

    private final Long id;
    private final String name;
    private final String imageUrl;
    private final CompanyTO company;

    @JsonCreator
    public FlavorTO(
            @JsonProperty("id") final Long id,
            @JsonProperty("name") final String name,
            @JsonProperty("imageUrl") final String imageUrl,
            @JsonProperty("company") final CompanyTO company) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.company = company;
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

    public CompanyTO getCompany() {
        return company;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FlavorTO flavorTO = (FlavorTO) o;
        return Objects.equals(id, flavorTO.id) &&
                Objects.equals(name, flavorTO.name) &&
                Objects.equals(imageUrl, flavorTO.imageUrl) &&
                Objects.equals(company, flavorTO.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUrl, company);
    }

    @Override
    public String toString() {
        return "FlavorTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", company=" + company +
                '}';
    }
}
