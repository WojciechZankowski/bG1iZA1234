package pl.zankowski.lmbd.commodities;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import pl.zankowski.lmbd.commodities.api.TickDataTO;
import pl.zankowski.lmbd.core.StringUtils;
import pl.zankowski.lmbd.core.mapper.LmbdObjectMapperProvider;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class CommoditiesWebSocketHandler implements WebSocketHandler {

    public static final String COMMODITIES_PATH = "/ws-commodities";

    private final CommoditiesService commoditiesService;
    private final LmbdObjectMapperProvider lmbdObjectMapperProvider;

    private Flux<TickDataTO> messageFlux;

    @Autowired
    public CommoditiesWebSocketHandler(final CommoditiesService commoditiesService,
            final LmbdObjectMapperProvider lmbdObjectMapperProvider) {
        this.commoditiesService = commoditiesService;
        this.lmbdObjectMapperProvider = lmbdObjectMapperProvider;
    }

    @PostConstruct
    private void init() {
        messageFlux = commoditiesService.getAsyncTickData();
    }

    @Override
    public Mono<Void> handle(final WebSocketSession session) {
        return session.send(
                messageFlux
                        .map(this::toJson) //transform to json
                        .map(session::textMessage)); // map to Spring WebSocketMessage of type text
    }

    private String toJson(final TickDataTO tickData) {
        try {
            return lmbdObjectMapperProvider.getObjectMapper().writeValueAsString(tickData);
        } catch (final JsonProcessingException e) {
            return StringUtils.EMPTY;
        }
    }

}
