package it.edo.tests.miscuglione2.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// @Component
public class StringListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "test-topic", groupId = "foo")
    public void listenGroupFoo(String message) {
        logger.info("Received Message in group foo: {}", message);
    }
}
