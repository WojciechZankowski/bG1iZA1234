package pl.lodomaniak.icecream.entity;

public final class CompanyEntityBuilder {
    private Long id;
    private String name;
    private String imageUrl;
    private String nip;
    private String regon;
    private AddressEntity addressEntity;

    public CompanyEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CompanyEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CompanyEntityBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CompanyEntityBuilder withNip(String nip) {
        this.nip = nip;
        return this;
    }

    public CompanyEntityBuilder withRegon(String regon) {
        this.regon = regon;
        return this;
    }

    public CompanyEntityBuilder withAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
        return this;
    }

    public CompanyEntity build() {
        return new CompanyEntity(id, name, imageUrl, nip, regon, addressEntity);
    }
}
