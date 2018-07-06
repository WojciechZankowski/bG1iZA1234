package pl.lodomaniak.app.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;

@Configuration
@EnableConfigurationProperties({LodomaniakConfigurationProperties.class})
@EntityScan("pl.lodomaniak")
@ComponentScan("pl.lodomaniak")
@EnableJpaRepositories("pl.lodomaniak")
public class LodomaniakConfiguration {

}
