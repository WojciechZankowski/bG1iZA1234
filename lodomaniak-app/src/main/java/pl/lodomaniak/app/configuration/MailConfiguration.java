package pl.lodomaniak.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import pl.lodomaniak.core.Constants;

@Configuration
public class MailConfiguration {

    @Bean
    public ClassLoaderTemplateResolver emailTemplateResolver() {
        final ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("mails/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding(Constants.UTF_8);
        resolver.setOrder(1);
        return resolver;
    }

}
