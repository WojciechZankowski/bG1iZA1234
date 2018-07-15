package pl.lodomaniak.icecream.entity;

import com.google.common.base.Objects;
import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lodomaniak_company")
public class CompanyEntity implements IEntity {

    private static final long serialVersionUID = 148625710782753189L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String imageUrl;

    @Column
    private String nip;

    @Column
    private String regon;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private AddressEntity address;

    public CompanyEntity() {
    }

    public CompanyEntity(
            final Long id,
            final String name,
            final String imageUrl,
            final String nip,
            final String regon,
            final AddressEntity address) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.nip = nip;
        this.regon = regon;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public AddressEntity getAddress() {
        return address;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CompanyEntity that = (CompanyEntity) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(name, that.name) &&
                Objects.equal(imageUrl, that.imageUrl) &&
                Objects.equal(nip, that.nip) &&
                Objects.equal(regon, that.regon) &&
                Objects.equal(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, imageUrl, nip, regon, address);
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", address=" + address +
                '}';
    }
}
