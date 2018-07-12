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
@Table(name = "lodomaniak_ice_cream_shop")
public class IceCreamShopEntity implements IEntity {

    private static final long serialVersionUID = 3853964512133627417L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false, updatable = false)
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", nullable = false, updatable = false)
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "OPENING_HOURS_ID", nullable = false, updatable = false)
    private OpeningHoursEntity openingHours;

    public IceCreamShopEntity() {
    }

    public IceCreamShopEntity(
            final String imageUrl,
            final CompanyEntity company,
            final AddressEntity address,
            final OpeningHoursEntity openingHours) {
        this.imageUrl = imageUrl;
        this.company = company;
        this.address = address;
        this.openingHours = openingHours;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public OpeningHoursEntity getOpeningHours() {
        return openingHours;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IceCreamShopEntity that = (IceCreamShopEntity) o;
        return Objects.equal(imageUrl, that.imageUrl) &&
                Objects.equal(company, that.company) &&
                Objects.equal(address, that.address) &&
                Objects.equal(openingHours, that.openingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(imageUrl, company, address, openingHours);
    }

    @Override
    public String toString() {
        return "IceCreamShopEntity{" +
                "imageUrl='" + imageUrl + '\'' +
                ", company=" + company +
                ", address=" + address +
                ", openingHours=" + openingHours +
                '}';
    }
}
