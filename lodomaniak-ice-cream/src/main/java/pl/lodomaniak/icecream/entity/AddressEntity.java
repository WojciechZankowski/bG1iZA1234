package pl.lodomaniak.icecream.entity;

import com.google.common.base.Objects;
import com.neovisionaries.i18n.CountryCode;
import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lodomaniak_address")
public class AddressEntity implements IEntity {

    private static final long serialVersionUID = 6009512953688468971L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String streetAddress;

    @Column
    private String city;

    @Column
    private String county;

    @Column
    private String zipCode;

    @Column
    @Enumerated(EnumType.STRING)
    private CountryCode countryCode;

    public AddressEntity() {
    }

    public AddressEntity(
            final Long id,
            final String streetAddress,
            final String city,
            final String county,
            final String zipCode,
            final CountryCode countryCode) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.city = city;
        this.county = county;
        this.zipCode = zipCode;
        this.countryCode = countryCode;
    }

    public Long getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getZipCode() {
        return zipCode;
    }

    public CountryCode getCountryCode() {
        return countryCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AddressEntity that = (AddressEntity) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(streetAddress, that.streetAddress) &&
                Objects.equal(city, that.city) &&
                Objects.equal(county, that.county) &&
                Objects.equal(zipCode, that.zipCode) &&
                countryCode == that.countryCode;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, streetAddress, city, county, zipCode, countryCode);
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", countryCode=" + countryCode +
                '}';
    }
}
