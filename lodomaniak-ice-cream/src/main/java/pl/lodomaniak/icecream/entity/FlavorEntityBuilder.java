package pl.lodomaniak.icecream.entity;

import java.util.List;

public final class FlavorEntityBuilder {
    private Long id;
    private String name;
    private String imageUrl;
    private List<String> tags;
    private CompanyEntity company;

    public FlavorEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FlavorEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FlavorEntityBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public FlavorEntityBuilder withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public FlavorEntityBuilder withCompany(CompanyEntity company) {
        this.company = company;
        return this;
    }

    public FlavorEntity build() {
        return new FlavorEntity(id, name, imageUrl, tags, company);
    }
}
