package pl.zankowski.lmbd.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import pl.zankowski.lmbd.commodities.CommoditiesWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

import static pl.zankowski.lmbd.commodities.CommoditiesWebSocketHandler.COMMODITIES_PATH;

@Configuration
public class WebSocketConfig {

    private final CommoditiesWebSocketHandler commoditiesWebSocketHandler;

    @Autowired
    public WebSocketConfig(final CommoditiesWebSocketHandler commoditiesWebSocketHandler) {
        this.commoditiesWebSocketHandler = commoditiesWebSocketHandler;
    }

    @Bean
    public HandlerMapping webSocketMapping() {
        final Map<String, WebSocketHandler> map = new HashMap<>();
        map.put(COMMODITIES_PATH, commoditiesWebSocketHandler);

        final SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(10);
        mapping.setUrlMap(map);
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

}
