package pl.lodomaniak.icecream.api;

public final class CompanyTOBuilder {
    private Long id;
    private String name;
    private String imageUrl;
    private String nip;
    private String regon;
    private AddressTO address;

    public CompanyTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CompanyTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CompanyTOBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CompanyTOBuilder withNip(String nip) {
        this.nip = nip;
        return this;
    }

    public CompanyTOBuilder withRegon(String regon) {
        this.regon = regon;
        return this;
    }

    public CompanyTOBuilder withAddress(AddressTO address) {
        this.address = address;
        return this;
    }

    public CompanyTO build() {
        return new CompanyTO(id, name, imageUrl, nip, regon, address);
    }
}
