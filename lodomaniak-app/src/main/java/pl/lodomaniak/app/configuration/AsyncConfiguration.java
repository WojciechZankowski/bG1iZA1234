package pl.lodomaniak.app.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfiguration implements AsyncConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncConfiguration.class);

    private final LodomaniakConfigurationProperties lmbdConfigurationProperties;

    @Autowired
    public AsyncConfiguration(final LodomaniakConfigurationProperties lmbdConfigurationProperties) {
        this.lmbdConfigurationProperties = lmbdConfigurationProperties;
    }

    @Override
    @Bean
    public Executor getAsyncExecutor() {
        LOG.debug("Creating Async Task Executor.");

        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(lmbdConfigurationProperties.getAsync().getCorePoolSize());
        executor.setMaxPoolSize(lmbdConfigurationProperties.getAsync().getMaxPoolSize());
        executor.setQueueCapacity(lmbdConfigurationProperties.getAsync().getQueueCapacity());
        executor.setThreadNamePrefix(lmbdConfigurationProperties.getAsync().getThreadNamePrefix());

        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
