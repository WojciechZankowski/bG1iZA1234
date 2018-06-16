package pl.zankowski.lmbd.icecream.entity;

import java.time.DayOfWeek;
import java.util.Map;

public final class OpeningHoursEntityBuilder {
    private Map<DayOfWeek, OpeningHoursRangeEntity> openingHours;

    public OpeningHoursEntityBuilder withOpeningHours(Map<DayOfWeek, OpeningHoursRangeEntity> openingHours) {
        this.openingHours = openingHours;
        return this;
    }

    public OpeningHoursEntity build() {
        return new OpeningHoursEntity(openingHours);
    }
}
