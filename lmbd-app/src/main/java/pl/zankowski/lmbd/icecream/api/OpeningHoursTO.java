package pl.zankowski.lmbd.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;
import pl.zankowski.lmbd.core.ITransferObject;

import java.time.DayOfWeek;
import java.util.Map;

@JsonPropertyOrder({"openingHours"})
public class OpeningHoursTO implements ITransferObject {

    private static final long serialVersionUID = 5135151511190636163L;

    private final Map<DayOfWeek, OpeningHoursRangeTO> openingHours;

    @JsonCreator
    public OpeningHoursTO(
            @JsonProperty("openingHours") final Map<DayOfWeek, OpeningHoursRangeTO> openingHours) {
        this.openingHours = openingHours;
    }

    public Map<DayOfWeek, OpeningHoursRangeTO> getOpeningHours() {
        return openingHours;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final OpeningHoursTO that = (OpeningHoursTO) o;
        return Objects.equal(openingHours, that.openingHours);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(openingHours);
    }

    @Override
    public String toString() {
        return "OpeningHoursTO{" +
                "openingHours=" + openingHours +
                '}';
    }
}
