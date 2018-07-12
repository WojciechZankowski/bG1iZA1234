package pl.lodomaniak.icecream.entity;

import com.google.common.base.Objects;
import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lodomaniak_opening_hours_ranges")
public class OpeningHoursRangeEntity implements IEntity {

    private static final long serialVersionUID = 1066607389165177609L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column
    private String openHour;

    @Column
    private String closeHour;

    public OpeningHoursRangeEntity() {
    }

    public OpeningHoursRangeEntity(final String openHour, final String closeHour) {
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    public Long getId() {
        return id;
    }

    public String getOpenHour() {
        return openHour;
    }

    public String getCloseHour() {
        return closeHour;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OpeningHoursRangeEntity that = (OpeningHoursRangeEntity) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(openHour, that.openHour) &&
                Objects.equal(closeHour, that.closeHour);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, openHour, closeHour);
    }

    @Override
    public String toString() {
        return "OpeningHoursRangeEntity{" +
                "id=" + id +
                ", openHour='" + openHour + '\'' +
                ", closeHour='" + closeHour + '\'' +
                '}';
    }
}
