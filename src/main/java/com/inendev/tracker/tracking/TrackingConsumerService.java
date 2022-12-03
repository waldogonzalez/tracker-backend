package com.inendev.tracker.tracking;

import com.inendev.tracker.dto.TrackingPayload;
import com.inendev.tracker.mqtt.MqttProperties;
import com.inendev.tracker.mqtt.MqttService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class TrackingConsumerService {

    private final MqttService mqttService;
    private final String trackingTopic;
    private final TrackingService payloadService;
    private final Logger logger = LoggerFactory.getLogger(TrackingConsumerService.class);
    private final BlockingQueue<TrackingPayload> queue = new LinkedBlockingDeque<>();

    public TrackingConsumerService(MqttService mqttService, MqttProperties mqttProperties, TrackingService payloadService) {
        this.mqttService = mqttService;
        this.trackingTopic = mqttProperties.getTopics().getTracking();
        this.payloadService = payloadService;
        logger.info("Mqtt client listening on topic " + trackingTopic);
    }

    @PostConstruct
    public void init() {
        try {
            mqttService.subscribe(trackingTopic, (topic, payload) -> {
                this.queue.add(payload);
            }, TrackingPayload.class);
        } catch (MqttException e) {
            logger.error("Error subscribing to topic " + trackingTopic);
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void saveTask() {
        if (!queue.isEmpty()) {
            TrackingPayload tp = queue.remove();
            try {
                this.payloadService.save(tp);
            } catch (Exception e) {
                // renqueue in case of error
                e.printStackTrace();
                queue.add(tp);
            }
        }
    }
}
