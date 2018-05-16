package pl.zankowski.lmbd.commodities;

import pl.zankowski.lmbd.commodities.api.TickDataTO;

@FunctionalInterface
public interface CommoditiesDataProviderListener {

    void handle(TickDataTO tickData);

}
