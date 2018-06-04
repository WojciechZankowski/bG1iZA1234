package pl.zankowski.lmbd.commodities;

import pl.zankowski.lmbd.commodities.api.CommoditySymbol;
import pl.zankowski.lmbd.commodities.api.TickDataTO;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CommoditiesService {

    List<CommoditySymbol> getAvailableSymbols();

    List<TickDataTO> getCommoditiesData(List<CommoditySymbol> commoditySymbolList);

    Flux<TickDataTO> getAsyncTickData();

}
