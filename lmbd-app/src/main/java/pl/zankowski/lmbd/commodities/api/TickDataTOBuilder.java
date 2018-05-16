package pl.zankowski.lmbd.commodities.api;

import org.joda.money.BigMoney;
import pl.zankowski.lmbd.core.Percentage;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class TickDataTOBuilder {

    private String ticker;
    private BigMoney price;
    private BigDecimal change;
    private Percentage changeInPercentage;
    private LocalDateTime time;

    public TickDataTOBuilder withTicker(final String ticker) {
        this.ticker = ticker;
        return this;
    }

    public TickDataTOBuilder withPrice(final BigMoney price) {
        this.price = price;
        return this;
    }

    public TickDataTOBuilder withChange(final BigDecimal change) {
        this.change = change;
        return this;
    }

    public TickDataTOBuilder withChangeInPercentage(final Percentage changeInPercentage) {
        this.changeInPercentage = changeInPercentage;
        return this;
    }

    public TickDataTOBuilder withTime(final LocalDateTime time) {
        this.time = time;
        return this;
    }

    public TickDataTO build() {
        return new TickDataTO(ticker, price, change, changeInPercentage, time);
    }
}
