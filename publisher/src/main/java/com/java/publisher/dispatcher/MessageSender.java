package com.java.publisher.dispatcher;

public interface MessageSender {
    void publish(String message);
    void publishTopic(String message);
}
