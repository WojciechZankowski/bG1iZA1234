package pl.zankowski.lmbd.icecream.entity;

import com.google.common.base.Objects;
import pl.zankowski.lmbd.core.IEntity;

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
@Table(name="lmbd_flavors")
public class FlavorEntity implements IEntity {

    private static final long serialVersionUID = 8365531052096887778L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    private String name;

    @Column
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false, updatable = false)
    private CompanyEntity company;

    public FlavorEntity() {
    }

    public FlavorEntity(final String name, final String imageUrl, final CompanyEntity company) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.company = company;
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

    public CompanyEntity getCompany() {
        return company;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FlavorEntity that = (FlavorEntity) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(name, that.name) &&
                Objects.equal(imageUrl, that.imageUrl) &&
                Objects.equal(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, imageUrl, company);
    }

    @Override
    public String toString() {
        return "FlavorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", company=" + company +
                '}';
    }
}