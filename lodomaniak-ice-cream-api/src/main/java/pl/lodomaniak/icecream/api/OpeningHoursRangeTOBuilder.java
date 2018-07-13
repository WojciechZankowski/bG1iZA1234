package pl.lodomaniak.icecream.api;

import java.time.DayOfWeek;

public final class OpeningHoursRangeTOBuilder {
    private DayOfWeek dayOfWeek;
    private String openHour;
    private String closeHour;

    public OpeningHoursRangeTOBuilder withDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    public OpeningHoursRangeTOBuilder withOpenHour(String openHour) {
        this.openHour = openHour;
        return this;
    }

    public OpeningHoursRangeTOBuilder withCloseHour(String closeHour) {
        this.closeHour = closeHour;
        return this;
    }

    public OpeningHoursRangeTO build() {
        return new OpeningHoursRangeTO(dayOfWeek, openHour, closeHour);
    }
}
