package com.java.publisher.service;

import com.java.publisher.dispatcher.MessageSender;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MessageOperationServiceImp implements MessageOperationService {

    MessageSender messageSender;

    @Override
    public void sendMessageQueue(String message) {
        messageSender.publish(message);
    }

    @Override
    public void sendMessageTopic(String message) {
        messageSender.publishTopic(message);
    }
}
