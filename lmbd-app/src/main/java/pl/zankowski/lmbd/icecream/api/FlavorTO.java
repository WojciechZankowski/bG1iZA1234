package pl.zankowski.lmbd.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;
import pl.zankowski.lmbd.core.ITransferObject;

@JsonPropertyOrder({"name"})
public class FlavorTO implements ITransferObject {

    private static final long serialVersionUID = -4066707497502285434L;

    private final String name;
    private final String imageUrl;

    @JsonCreator
    public FlavorTO(
            @JsonProperty("name") final String name,
            @JsonProperty("imageUrl") final String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FlavorTO flavorTO = (FlavorTO) o;
        return Objects.equal(name, flavorTO.name) &&
                Objects.equal(imageUrl, flavorTO.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, imageUrl);
    }

    @Override
    public String toString() {
        return "FlavorTO{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
