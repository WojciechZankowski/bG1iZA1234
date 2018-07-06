package pl.lodomaniak.icecream.entity;

import com.google.common.base.Objects;
import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lmbd_company")
public class CompanyEntity implements IEntity {

    private static final long serialVersionUID = 148625710782753189L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    private String name;

    @Column
    private String imageUrl;

    @Column
    private String nip;

    @Column
    private String regon;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", nullable = false, updatable = false)
    private AddressEntity addressEntity;

    public CompanyEntity() {
    }

    public CompanyEntity(
            final String name,
            final String imageUrl,
            final String nip,
            final String regon,
            final AddressEntity addressEntity) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.nip = nip;
        this.regon = regon;
        this.addressEntity = addressEntity;
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

    public AddressEntity getAddressEntity() {
        return addressEntity;
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
                Objects.equal(addressEntity, that.addressEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, imageUrl, nip, regon, addressEntity);
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", addressEntity=" + addressEntity +
                '}';
    }
}
