package pl.lodomaniak.icecream.api;

import java.time.DayOfWeek;
import java.util.Map;

public final class OpeningHoursTOBuilder {
    private Map<DayOfWeek, OpeningHoursRangeTO> openingHours;

    public OpeningHoursTOBuilder withOpeningHours(Map<DayOfWeek, OpeningHoursRangeTO> openingHours) {
        this.openingHours = openingHours;
        return this;
    }

    public OpeningHoursTO build() {
        return new OpeningHoursTO(openingHours);
    }
}
