package pl.lodomaniak.icecream.entity;

import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "lodomaniak_flavors")
public class FlavorEntity implements IEntity {

    private static final long serialVersionUID = 8365531052096887778L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String imageUrl;

    @ElementCollection
    @CollectionTable(name = "lodomaniak_flavors_tags")
    private List<String> tags;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "COMPANY_ID", nullable = false, updatable = false)
    private CompanyEntity company;

    public FlavorEntity() {
    }

    public FlavorEntity(final Long id, final String name, final String imageUrl, final List<String> tags,
            final CompanyEntity company) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.tags = tags;
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

    public List<String> getTags() {
        return tags;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FlavorEntity that = (FlavorEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUrl, tags, company);
    }

    @Override
    public String toString() {
        return "FlavorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tags=" + tags +
                ", company=" + company +
                '}';
    }
}
