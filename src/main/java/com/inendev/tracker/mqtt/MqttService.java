package com.inendev.tracker.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MqttService {
    private final IMqttClient mqttClient;
    private final ObjectMapper mapper = new ObjectMapper();

    public MqttService(IMqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    @Async
    public void publish(String topic, Object payload) throws JsonProcessingException, MqttException {
        MqttMessage msg = new MqttMessage(mapper.writeValueAsBytes(payload));
        msg.setQos(0);
        mqttClient.publish(topic, msg);
    }

    public void subscribe(String topic, IMqttMessageListener listener) throws MqttException {
        mqttClient.subscribe(topic, listener);
    }

    public <T> void subscribe(String topic, IMqttCallback<T> callback, Class<T> clazz) throws MqttException {
        mqttClient.subscribe(topic, (t, msg) -> {
            try {
                T payload = mapper.readValue(msg.getPayload(), clazz);
                callback.callback(topic, payload);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public interface IMqttCallback<T> {
        void callback(String topic, T payload);
    }
}
