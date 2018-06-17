package pl.zankowski.lmbd.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

@JsonPropertyOrder({"openHour", "closeHour"})
public class OpeningHoursRangeTO {

    private final String openHour;
    private final String closeHour;

    @JsonCreator
    public OpeningHoursRangeTO(
            @JsonProperty("openHour") final String openHour,
            @JsonProperty("closeHour") final String closeHour) {
        this.openHour = openHour;
        this.closeHour = closeHour;
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
        return Objects.equal(openHour, that.openHour) &&
                Objects.equal(closeHour, that.closeHour);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(openHour, closeHour);
    }

    @Override
    public String toString() {
        return "OpeningHoursRangeTO{" +
                "openHour='" + openHour + '\'' +
                ", closeHour='" + closeHour + '\'' +
                '}';
    }
}