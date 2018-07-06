package pl.lodomaniak.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class Percentage implements Comparable<Percentage>, Serializable {

    private static final long serialVersionUID = -6862978105778642875L;

    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    private final BigDecimal fraction;

    private Percentage(final BigDecimal fraction) {
        requireNonNull(fraction, "Fraction cannot be a null in Percentage object.");
        this.fraction = fraction;
    }

    public static Percentage createFromFraction(final BigDecimal fraction) {
        return fraction == null ? null : new Percentage(fraction);
    }

    public static Percentage createFromPercentage(final BigDecimal percentage) {
        return percentage == null ? null : new Percentage(percentage.divide(ONE_HUNDRED, MathContext.DECIMAL128));
    }

    public BigDecimal getFraction() {
        return fraction;
    }

    public BigDecimal getPercentage() {
        return fraction.multiply(ONE_HUNDRED);
    }

    @Override
    public int compareTo(final Percentage that) {
        if (that == null) {
            return 1;
        }
        return fraction.compareTo(that.fraction);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Percentage that = (Percentage) o;
        return Objects.equals(fraction, that.fraction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fraction);
    }

    @Override
    public String toString() {
        return "Percentage{" +
                "fraction=" + fraction +
                '}';
    }
}
