package com.inendev.tracker.mqtt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mqtt")
public class MqttProperties {
    /**
     * Mqtt server url, prefix tcp!!!
     */
    private String url;

    private String userName;

    /**s
     * Optional password for server
     */
    private String pass;
    /**
     * Optional password for server
     */
    private Topics topics = new Topics();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static class Topics {
        private String root;
        private String tracking;

        public String getRoot() {
            return root;
        }

        public void setRoot(String root) {
            this.root = root;
        }

        public String getTracking() {
            return root + "/" + tracking;
        }

        public void setTracking(String tracking) {
            this.tracking = tracking;
        }
    }
}
