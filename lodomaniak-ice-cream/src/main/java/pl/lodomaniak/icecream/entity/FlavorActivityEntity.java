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
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "lodomaniak_flavor_activity")
public class FlavorActivityEntity implements IEntity {

    private static final long serialVersionUID = 5557611084628542593L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "FLAVOR_ID", nullable = false, updatable = false)
    private FlavorEntity flavor;

    @ManyToOne
    @JoinColumn(name = "ICE_CREAM_SHOP_ID", nullable = false, updatable = false)
    private IceCreamShopEntity iceCreamShop;

    public FlavorActivityEntity() {
    }

    public FlavorActivityEntity(final Long id, final LocalDate date, final FlavorEntity flavor,
            final IceCreamShopEntity iceCreamShop) {
        this.date = date;
        this.flavor = flavor;
        this.iceCreamShop = iceCreamShop;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public FlavorEntity getFlavor() {
        return flavor;
    }

    public IceCreamShopEntity getIceCreamShop() {
        return iceCreamShop;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FlavorActivityEntity that = (FlavorActivityEntity) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(date, that.date) &&
                Objects.equal(flavor, that.flavor) &&
                Objects.equal(iceCreamShop, that.iceCreamShop);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, date, flavor, iceCreamShop);
    }

    @Override
    public String toString() {
        return "FlavorActivityEntity{" +
                "id=" + id +
                ", date=" + date +
                ", flavor=" + flavor +
                ", iceCreamShop=" + iceCreamShop +
                '}';
    }
}
