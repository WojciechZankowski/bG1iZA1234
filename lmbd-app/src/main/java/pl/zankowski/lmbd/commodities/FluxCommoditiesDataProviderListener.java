package pl.zankowski.lmbd.commodities;

import pl.zankowski.lmbd.commodities.api.TickDataTO;
import reactor.core.publisher.FluxSink;

public class FluxCommoditiesDataProviderListener implements CommoditiesDataProviderListener {

    private final FluxSink<TickDataTO> emitter;

    public FluxCommoditiesDataProviderListener(final FluxSink<TickDataTO> emitter) {
        this.emitter = emitter;
    }

    @Override
    public void handle(final TickDataTO tickData) {
        emitter.next(tickData);
    }

}
