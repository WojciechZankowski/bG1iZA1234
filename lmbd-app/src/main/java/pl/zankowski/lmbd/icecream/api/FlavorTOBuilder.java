package pl.zankowski.lmbd.icecream.api;

public final class FlavorTOBuilder {
    private String name;
    private String imageUrl;

    public FlavorTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FlavorTOBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public FlavorTO build() {
        return new FlavorTO(name, imageUrl);
    }
}
