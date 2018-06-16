package pl.zankowski.lmbd.icecream.entity;

public final class OpeningHoursRangeEntityBuilder {
    private String openHour;
    private String closeHour;

    public OpeningHoursRangeEntityBuilder withOpenHour(String openHour) {
        this.openHour = openHour;
        return this;
    }

    public OpeningHoursRangeEntityBuilder withCloseHour(String closeHour) {
        this.closeHour = closeHour;
        return this;
    }

    public OpeningHoursRangeEntity build() {
        return new OpeningHoursRangeEntity(openHour, closeHour);
    }
}
