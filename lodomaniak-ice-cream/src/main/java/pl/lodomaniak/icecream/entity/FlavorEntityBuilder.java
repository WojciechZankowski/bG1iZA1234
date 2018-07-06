package pl.lodomaniak.icecream.entity;

public final class FlavorEntityBuilder {
    private String name;
    private String imageUrl;
    private CompanyEntity companyEntity;

    public FlavorEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FlavorEntityBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public FlavorEntityBuilder withCompanyEntity(final CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
        return this;
    }

    public FlavorEntity build() {
        return new FlavorEntity(name, imageUrl, companyEntity);
    }
}
