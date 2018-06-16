package pl.zankowski.lmbd.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@ConfigurationProperties(
        prefix = "lmbd",
        ignoreUnknownFields = false
)
public class LmbdConfigurationProperties {

    private final LmbdConfigurationProperties.Mail mail = new LmbdConfigurationProperties.Mail();
    private final LmbdConfigurationProperties.Async async = new LmbdConfigurationProperties.Async();
    private final LmbdConfigurationProperties.Security security = new LmbdConfigurationProperties.Security();
    private final CorsConfiguration cors = new CorsConfiguration();

    public LmbdConfigurationProperties() {
    }

    public Async getAsync() {
        return async;
    }

    public CorsConfiguration getCors() {
        return cors;
    }

    public Mail getMail() {
        return mail;
    }

    public Security getSecurity() {
        return security;
    }

    public static class Mail {

        private String from = "";
        private String baseUrl = "";

        public Mail() {
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(final String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(final String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Async {

        private int corePoolSize;
        private int maxPoolSize;
        private int queueCapacity;
        private String threadNamePrefix;

        public Async() {
        }

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(final int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(final int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(final int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }

        public String getThreadNamePrefix() {
            return threadNamePrefix;
        }

        public void setThreadNamePrefix(final String threadNamePrefix) {
            this.threadNamePrefix = threadNamePrefix;
        }
    }

    public static class Security {

        private String secretKey;
        private long tokenValidityInMilliseconds;
        private long tokenValidityInMillisecondsForRememberMe;

        public Security() {
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(final String secretKey) {
            this.secretKey = secretKey;
        }

        public long getTokenValidityInMilliseconds() {
            return tokenValidityInMilliseconds;
        }

        public void setTokenValidityInMilliseconds(final long tokenValidityInMilliseconds) {
            this.tokenValidityInMilliseconds = tokenValidityInMilliseconds;
        }

        public long getTokenValidityInMillisecondsForRememberMe() {
            return tokenValidityInMillisecondsForRememberMe;
        }

        public void setTokenValidityInMillisecondsForRememberMe(final long tokenValidityInMillisecondsForRememberMe) {
            this.tokenValidityInMillisecondsForRememberMe = tokenValidityInMillisecondsForRememberMe;
        }
    }

}
