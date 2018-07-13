package pl.lodomaniak.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.DayOfWeek;
import java.util.Objects;

@JsonPropertyOrder({"dayOfWeek", "openHour", "closeHour"})
public class OpeningHoursRangeTO {

    private final DayOfWeek dayOfWeek;
    private final String openHour;
    private final String closeHour;

    @JsonCreator
    public OpeningHoursRangeTO(
            @JsonProperty("dayOfWeek") final DayOfWeek dayOfWeek,
            @JsonProperty("openHour") final String openHour,
            @JsonProperty("closeHour") final String closeHour) {
        this.dayOfWeek = dayOfWeek;
        this.openHour = openHour;
        this.closeHour = closeHour;
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
        final OpeningHoursRangeTO that = (OpeningHoursRangeTO) o;
        return dayOfWeek == that.dayOfWeek &&
                Objects.equals(openHour, that.openHour) &&
                Objects.equals(closeHour, that.closeHour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dayOfWeek, openHour, closeHour);
    }

    @Override
    public String toString() {
        return "OpeningHoursRangeTO{" +
                "dayOfWeek=" + dayOfWeek +
                ", openHour='" + openHour + '\'' +
                ", closeHour='" + closeHour + '\'' +
                '}';
    }
}
