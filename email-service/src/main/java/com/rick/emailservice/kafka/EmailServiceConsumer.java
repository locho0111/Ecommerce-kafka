package com.rick.emailservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.rick.basedomains.dto.OrderEvent;

@Service
public class EmailServiceConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrderEvent(OrderEvent orderEvent) {
        LOGGER.info(String.format("Received order event => %s", orderEvent.toString()));
        // save to databse
    }
}
