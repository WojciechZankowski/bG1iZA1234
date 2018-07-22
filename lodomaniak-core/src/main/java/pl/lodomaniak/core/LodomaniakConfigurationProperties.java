package pl.lodomaniak.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "lodomaniak",
        ignoreUnknownFields = false
)
public class LodomaniakConfigurationProperties {

    private final LodomaniakConfigurationProperties.Mail mail = new LodomaniakConfigurationProperties.Mail();
    private final LodomaniakConfigurationProperties.Async async = new LodomaniakConfigurationProperties.Async();
    private final LodomaniakConfigurationProperties.Security security = new LodomaniakConfigurationProperties.Security();
    private final LodomaniakConfigurationProperties.Image image = new LodomaniakConfigurationProperties.Image();
    private final LodomaniakConfigurationProperties.Social social = new LodomaniakConfigurationProperties.Social();

    public LodomaniakConfigurationProperties() {
    }

    public Async getAsync() {
        return async;
    }


    public Mail getMail() {
        return mail;
    }

    public Image getImage() {
        return image;
    }

    public Security getSecurity() {
        return security;
    }

    public Social getSocial() {
        return social;
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

    public static class Image {

        private String path;

        public Image() {
        }

        public String getPath() {
            return path;
        }

        public void setPath(final String path) {
            this.path = path;
        }
    }

    public static class Social {

        private String redirectAfterSignIn;

        public Social() {
        }

        public String getRedirectAfterSignIn() {
            return redirectAfterSignIn;
        }

        public void setRedirectAfterSignIn(final String redirectAfterSignIn) {
            this.redirectAfterSignIn = redirectAfterSignIn;
        }
    }

}
