package pl.lodomaniak.user.entity;

public final class AuthorityEntityBuilder {
    private String name;

    public AuthorityEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AuthorityEntity build() {
        return new AuthorityEntity(name);
    }
}
