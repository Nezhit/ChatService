package com.petchat.registration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaAuth {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserSessionInfo(String username, String sessionInfo) {
        kafkaTemplate.send("userSessionTopic", username, sessionInfo);
    }

}
