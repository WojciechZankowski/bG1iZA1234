package pl.lodomaniak.icecream.entity;

import com.google.common.base.Objects;
import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.util.Map;

@Entity
@Table(name = "lmbd_opening_hours")
public class OpeningHoursEntity implements IEntity {

    private static final long serialVersionUID = -5878631343997198494L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;


    @OneToMany
    @JoinColumn(name = "RANGE_ID", nullable = false, updatable = false)
    private Map<DayOfWeek, OpeningHoursRangeEntity> openingHours;

    public OpeningHoursEntity() {
    }

    public OpeningHoursEntity(final Map<DayOfWeek, OpeningHoursRangeEntity> openingHours) {
        this.openingHours = openingHours;
    }

    public Long getId() {
        return id;
    }

    public Map<DayOfWeek, OpeningHoursRangeEntity> getOpeningHours() {
        return openingHours;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OpeningHoursEntity that = (OpeningHoursEntity) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(openingHours, that.openingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, openingHours);
    }

    @Override
    public String toString() {
        return "OpeningHoursEntity{" +
                "id=" + id +
                ", openingHours=" + openingHours +
                '}';
    }
}
