package pl.lodomaniak.icecream.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.lodomaniak.core.ITransferObject;

import java.time.LocalDate;
import java.util.Objects;

@JsonPropertyOrder({"id", "date", "flavor", "iceCreamShop"})
public class FlavorActivityTO implements ITransferObject {

    private static final long serialVersionUID = -5554490708990918265L;

    private final Long id;
    private final LocalDate date;
    private final FlavorTO flavor;
    private final IceCreamShopTO iceCreamShop;

    @JsonCreator
    public FlavorActivityTO(
            @JsonProperty("id") final Long id,
            @JsonProperty("date") final LocalDate date,
            @JsonProperty("flavor") final FlavorTO flavor,
            @JsonProperty("iceCreamShop") final IceCreamShopTO iceCreamShop) {
        this.id = id;
        this.date = date;
        this.flavor = flavor;
        this.iceCreamShop = iceCreamShop;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public FlavorTO getFlavor() {
        return flavor;
    }

    public IceCreamShopTO getIceCreamShop() {
        return iceCreamShop;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final FlavorActivityTO that = (FlavorActivityTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(flavor, that.flavor) &&
                Objects.equals(iceCreamShop, that.iceCreamShop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, flavor, iceCreamShop);
    }

    @Override
    public String toString() {
        return "FlavorActivityTO{" +
                "id=" + id +
                ", date=" + date +
                ", flavor=" + flavor +
                ", iceCreamShop=" + iceCreamShop +
                '}';
    }
}
