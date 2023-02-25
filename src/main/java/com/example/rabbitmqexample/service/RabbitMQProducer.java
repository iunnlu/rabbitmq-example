package com.example.rabbitmqexample.service;

import com.example.rabbitmqexample.config.RabbitMQProperties;
import com.example.rabbitmqexample.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQProducer {
    private final RabbitTemplate rabbitTemplate;

    public void addMessageToQueue(Comment comment) {
        this.rabbitTemplate.convertAndSend(RabbitMQProperties.topicExchangeName, RabbitMQProperties.topicExchangeKey, comment);
    }
}
