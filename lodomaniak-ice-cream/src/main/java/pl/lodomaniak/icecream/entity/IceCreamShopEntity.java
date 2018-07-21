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
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "lodomaniak_ice_cream_shop")
public class IceCreamShopEntity implements IEntity {

    private static final long serialVersionUID = 3853964512133627417L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private CompanyEntity company;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private AddressEntity address;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ICE_CREM_SHOP_ID", nullable = false)
    @MapKey(name = "dayOfWeek")
    private Map<DayOfWeek, OpeningHoursRangeEntity> openingHours;

    public IceCreamShopEntity() {
    }

    public IceCreamShopEntity(
            final Long id,
            final String imageUrl,
            final CompanyEntity company,
            final AddressEntity address,
            final Map<DayOfWeek, OpeningHoursRangeEntity> openingHours) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.company = company;
        this.address = address;
        this.openingHours = openingHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(final CompanyEntity company) {
        this.company = company;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(final AddressEntity address) {
        this.address = address;
    }

    public Map<DayOfWeek, OpeningHoursRangeEntity> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(final Map<DayOfWeek, OpeningHoursRangeEntity> openingHours) {
        this.openingHours = openingHours;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IceCreamShopEntity that = (IceCreamShopEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(company, that.company) &&
                Objects.equals(address, that.address) &&
                Objects.equals(openingHours, that.openingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageUrl, company, address, openingHours);
    }

    @Override
    public String toString() {
        return "IceCreamShopEntity{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", company=" + company +
                ", address=" + address +
                ", openingHours=" + openingHours +
                '}';
    }
}
