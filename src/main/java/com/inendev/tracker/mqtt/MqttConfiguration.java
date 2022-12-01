package com.inendev.tracker.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfiguration {
    @Value("${mqtt.url}")
    private String url;
    @Value("${mqtt.pass}")
    private String pass;

    @Bean
    public IMqttClient mqttClient() throws MqttException {
        MqttClient mqttclient = new MqttClient(url, "demo");
        MqttConnectOptions options = new MqttConnectOptions();
        if (pass != null) {
            options.setPassword(pass.toCharArray());
        }
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        //options.setKeepAliveInterval(0);
        mqttclient.connect(options);
        return mqttclient;
    }
}
