package com.java.publisher.service;

public interface MessageOperationService {

    void sendMessageQueue(String message);
    void sendMessageTopic(String message);
}
