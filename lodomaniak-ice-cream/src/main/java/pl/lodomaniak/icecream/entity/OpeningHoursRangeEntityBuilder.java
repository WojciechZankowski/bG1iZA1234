package pl.lodomaniak.icecream.entity;

import java.time.DayOfWeek;

public final class OpeningHoursRangeEntityBuilder {
    private Long id;
    private DayOfWeek dayOfWeek;
    private String openHour;
    private String closeHour;

    public OpeningHoursRangeEntityBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public OpeningHoursRangeEntityBuilder withDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    public OpeningHoursRangeEntityBuilder withOpenHour(String openHour) {
        this.openHour = openHour;
        return this;
    }

    public OpeningHoursRangeEntityBuilder withCloseHour(String closeHour) {
        this.closeHour = closeHour;
        return this;
    }

    public OpeningHoursRangeEntity build() {
        return new OpeningHoursRangeEntity(id, dayOfWeek, openHour, closeHour);
    }
}
