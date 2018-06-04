package pl.zankowski.lmbd.commodities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zankowski.lmbd.commodities.api.CommoditySymbol;
import pl.zankowski.lmbd.commodities.api.TickDataTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class DefaultCommoditiesService implements CommoditiesService {

    private final CommoditiesDataProvider commoditiesDataProvider;

    @Autowired
    public DefaultCommoditiesService(final CommoditiesDataProvider commoditiesDataProvider) {
        this.commoditiesDataProvider = commoditiesDataProvider;
    }

    @Override
    public List<CommoditySymbol> getAvailableSymbols() {
        return asList(CommoditySymbol.values());
    }

    @Override
    public List<TickDataTO> getCommoditiesData(final List<CommoditySymbol> commoditySymbolList) {
        return commoditiesDataProvider.getTickData(commoditySymbolList);
    }

    @Override
    public Flux<TickDataTO> getAsyncTickData() {
        return Flux.create(this::addListenerToEmitter, FluxSink.OverflowStrategy.BUFFER);
    }

    private void addListenerToEmitter(final FluxSink<TickDataTO> emitter) {
        final FluxCommoditiesDataProviderListener listener = new FluxCommoditiesDataProviderListener(emitter);
        commoditiesDataProvider.addListener(listener);
    }

}
