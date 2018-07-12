package pl.lodomaniak.app.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final LodomaniakConfigurationProperties lodomaniakConfigurationProperties;

    @Autowired
    public WebConfiguration(final LodomaniakConfigurationProperties lodomaniakConfigurationProperties) {
        this.lodomaniakConfigurationProperties = lodomaniakConfigurationProperties;
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
