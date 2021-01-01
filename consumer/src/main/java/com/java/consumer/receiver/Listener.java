package com.java.consumer.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener {

    @JmsListener(destination = "${queue.name}", containerFactory = "queueConnectionFactory")
    public void consume(String message) {
        log.info("Received Message: " + message);
    }

    @JmsListener(destination = "${topic.name}", containerFactory = "topicConnectionFactory")
    public void consumeTopicOne(String message) {
        log.info("Received Message Topic1: " + message);
    }

    @JmsListener(destination = "${topic.name}", containerFactory = "topicConnectionFactory")
    public void consumeTopicTwo(String message) {
        log.info("Received Message Topic2: " + message);
    }

}
