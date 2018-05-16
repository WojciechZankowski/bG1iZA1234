package pl.zankowski.lmbd.commodities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zankowski.lmbd.commodities.api.CommoditySymbol;
import pl.zankowski.lmbd.commodities.api.TickDataTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.List;

@Service
public class CommoditiesService {

    private final CommoditiesDataProvider commoditiesDataProvider;

    @Autowired
    public CommoditiesService(final CommoditiesDataProvider commoditiesDataProvider) {
        this.commoditiesDataProvider = commoditiesDataProvider;
    }

    public List<TickDataTO> getCommoditiesData(final List<CommoditySymbol> commoditySymbolList) {
        return commoditiesDataProvider.getTickData(commoditySymbolList);
    }

    Flux<TickDataTO> getAsyncTickData() {
        return Flux.create(this::addListenerToEmitter, FluxSink.OverflowStrategy.BUFFER);
    }

    private void addListenerToEmitter(final FluxSink<TickDataTO> emitter) {
        final FluxCommoditiesDataProviderListener listener = new FluxCommoditiesDataProviderListener(emitter);
        commoditiesDataProvider.addListener(listener);
    }

}
