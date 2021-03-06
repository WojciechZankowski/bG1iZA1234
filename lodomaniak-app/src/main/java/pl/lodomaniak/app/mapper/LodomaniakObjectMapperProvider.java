package pl.lodomaniak.app.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class LodomaniakObjectMapperProvider {

    private final ObjectMapper objectMapper;

    public LodomaniakObjectMapperProvider() {
        objectMapper = initializeObjectMapper();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private ObjectMapper initializeObjectMapper() {
        final ObjectMapper customMapper = new ObjectMapper();

        customMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        customMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        customMapper.registerModule(new JavaTimeModule());
        customMapper.registerModule(lodomaniakModule());

        return customMapper;
    }

    private Module lodomaniakModule() {
        final SimpleModule module = new SimpleModule("iexTradingModule");

        return module;
    }

}
