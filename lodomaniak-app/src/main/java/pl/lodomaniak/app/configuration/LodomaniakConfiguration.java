package pl.lodomaniak.app.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;

@Configuration
@EnableConfigurationProperties({LodomaniakConfigurationProperties.class})
public class LodomaniakConfiguration {

}
