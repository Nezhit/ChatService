package com.petchat.chat.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KafkaChat {
    @KafkaListener(topics = "userSessionTopic",groupId = "chat-group")
    public void receiveUserSessionInfo(ConsumerRecord<String, String> record) {
        String username = record.key();
        String sessionInfo = record.value();
        System.out.println("AAAAAAAAAAA= "+username+" "+sessionInfo);

        // Здесь могут быть выполнены действия по инициализации сессии чата для пользователя
    }
}
