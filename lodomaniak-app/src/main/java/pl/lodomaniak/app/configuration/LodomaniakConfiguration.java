package pl.lodomaniak.app.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;

@Configuration
@EnableConfigurationProperties({LodomaniakConfigurationProperties.class})
@EntityScan("pl.lodomaniak")
@ComponentScan("pl.lodomaniak")
@EnableJpaRepositories("pl.lodomaniak")
public class LodomaniakConfiguration {



    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
                = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }

}
