package pl.lodomaniak.icecream.entity;

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
import java.util.List;
import java.util.Objects;

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

    @Column(updatable = false)
    private List<Long> userId;

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
            final List<Long> userId,
            final AddressEntity address) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.nip = nip;
        this.regon = regon;
        this.userId = userId;
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

    public List<Long> getUserId() {
        return userId;
    }

    public AddressEntity getAddress() {
        return address;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CompanyEntity that = (CompanyEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(nip, that.nip) &&
                Objects.equals(regon, that.regon) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUrl, nip, regon, userId, address);
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", userId=" + userId +
                ", address=" + address +
                '}';
    }
}
