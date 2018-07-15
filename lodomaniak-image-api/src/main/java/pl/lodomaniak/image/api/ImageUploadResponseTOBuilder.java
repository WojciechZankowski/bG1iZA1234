package pl.lodomaniak.image.api;

public final class ImageUploadResponseTOBuilder {

    private String name;

    public ImageUploadResponseTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ImageUploadResponseTO build() {
        return new ImageUploadResponseTO(name);
    }
}
