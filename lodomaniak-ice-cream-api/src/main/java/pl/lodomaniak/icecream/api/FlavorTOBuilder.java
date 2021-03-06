package pl.lodomaniak.icecream.api;

import java.util.List;

public final class FlavorTOBuilder {
    private Long id;
    private String name;
    private String imageUrl;
    private List<String> tags;
    private CompanyTO company;

    public FlavorTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FlavorTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public FlavorTOBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public FlavorTOBuilder withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public FlavorTOBuilder withCompany(CompanyTO company) {
        this.company = company;
        return this;
    }

    public FlavorTO build() {
        return new FlavorTO(id, name, imageUrl, tags, company);
    }
}
