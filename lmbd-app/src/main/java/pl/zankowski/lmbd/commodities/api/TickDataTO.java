package pl.zankowski.lmbd.commodities.api;

import org.joda.money.BigMoney;
import pl.zankowski.lmbd.core.ITransferObject;
import pl.zankowski.lmbd.core.Percentage;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class TickDataTO implements ITransferObject {

    private static final long serialVersionUID = -8612996410873619010L;

    private final String ticker;
    private final BigMoney price;
    private final BigDecimal change;
    private final Percentage changeInPercentage;
    private final LocalDateTime time;

    public TickDataTO(final String ticker,
            final BigMoney price,
            final BigDecimal change,
            final Percentage changeInPercentage,
            final LocalDateTime time) {
        this.ticker = ticker;
        this.price = price;
        this.change = change;
        this.changeInPercentage = changeInPercentage;
        this.time = time;
    }

    public String getTicker() {
        return ticker;
    }

    public BigMoney getPrice() {
        return price;
    }

    public BigDecimal getChange() {
        return change;
    }

    public Percentage getChangeInPercentage() {
        return changeInPercentage;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TickDataTO tickDataTO = (TickDataTO) o;
        return Objects.equals(ticker, tickDataTO.ticker) &&
                Objects.equals(price, tickDataTO.price) &&
                Objects.equals(change, tickDataTO.change) &&
                Objects.equals(changeInPercentage, tickDataTO.changeInPercentage) &&
                Objects.equals(time, tickDataTO.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker, price, change, changeInPercentage, time);
    }

    @Override
    public String toString() {
        return "TickDataTO{" +
                "ticker='" + ticker + '\'' +
                ", price=" + price +
                ", change=" + change +
                ", changeInPercentage=" + changeInPercentage +
                ", time=" + time +
                '}';
    }
}
