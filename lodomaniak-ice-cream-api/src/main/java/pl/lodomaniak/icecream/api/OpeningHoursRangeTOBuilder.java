package pl.lodomaniak.icecream.api;

public final class OpeningHoursRangeTOBuilder {
    private String openHour;
    private String closeHour;

    public OpeningHoursRangeTOBuilder withOpenHour(String openHour) {
        this.openHour = openHour;
        return this;
    }

    public OpeningHoursRangeTOBuilder withCloseHour(String closeHour) {
        this.closeHour = closeHour;
        return this;
    }

    public OpeningHoursRangeTO build() {
        return new OpeningHoursRangeTO(openHour, closeHour);
    }
}
