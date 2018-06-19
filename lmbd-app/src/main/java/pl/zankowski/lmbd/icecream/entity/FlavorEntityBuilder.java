package pl.zankowski.lmbd.icecream.entity;

public final class FlavorEntityBuilder {
    private String name;
    private String imageUrl;

    public FlavorEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FlavorEntityBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public FlavorEntity build() {
        return new FlavorEntity(name, imageUrl);
    }
}
