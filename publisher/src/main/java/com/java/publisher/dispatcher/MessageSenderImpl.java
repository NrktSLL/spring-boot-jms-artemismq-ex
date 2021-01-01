package com.java.publisher.dispatcher;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class MessageSenderImpl implements MessageSender {

    JmsTemplate jmsTemplate;

    @Value("${queue.name}")
    @NonFinal
    String queueName;

    @Value("${topic.name}")
    @NonFinal
    String topicName;


    @Override
    public void publish(String message) {
        jmsTemplate.convertAndSend(queueName, message);
        log.info("Message Sent: " + message);
    }

    @Override
    public void publishTopic(String message) {
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(topicName, message);
        log.info("Message Sent: " + message);
    }
}
