package pl.lodomaniak.icecream.entity;

import pl.lodomaniak.core.entity.IEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.util.Objects;

@Entity
@Table(name = "lodomaniak_opening_hours_ranges")
public class OpeningHoursRangeEntity implements IEntity {

    private static final long serialVersionUID = 1066607389165177609L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private DayOfWeek dayOfWeek;

    @Column
    private String openHour;

    @Column
    private String closeHour;

    public OpeningHoursRangeEntity() {
    }

    public OpeningHoursRangeEntity(final Long id, final DayOfWeek dayOfWeek,
            final String openHour, final String closeHour) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    public Long getId() {
        return id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
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
        return Objects.equals(id, that.id) &&
                dayOfWeek == that.dayOfWeek &&
                Objects.equals(openHour, that.openHour) &&
                Objects.equals(closeHour, that.closeHour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dayOfWeek, openHour, closeHour);
    }

    @Override
    public String toString() {
        return "OpeningHoursRangeEntity{" +
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                ", openHour='" + openHour + '\'' +
                ", closeHour='" + closeHour + '\'' +
                '}';
    }
}
