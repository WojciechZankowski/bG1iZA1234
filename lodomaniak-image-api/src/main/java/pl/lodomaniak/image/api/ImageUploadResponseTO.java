package pl.lodomaniak.image.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonPropertyOrder({"name"})
public class ImageUploadResponseTO {

    private final String name;

    @JsonCreator
    public ImageUploadResponseTO(
            @JsonProperty("name") final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ImageUploadResponseTO that = (ImageUploadResponseTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ImageUploadResponseTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
