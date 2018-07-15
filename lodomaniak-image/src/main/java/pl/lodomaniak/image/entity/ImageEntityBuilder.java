package pl.lodomaniak.image.entity;

public final class ImageEntityBuilder {
    private String name;
    private byte[] image;

    public ImageEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ImageEntityBuilder withImage(byte[] image) {
        this.image = image;
        return this;
    }

    public ImageEntity build() {
        return new ImageEntity(name, image);
    }
}
