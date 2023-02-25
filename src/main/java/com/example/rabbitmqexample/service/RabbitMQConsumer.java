package com.example.rabbitmqexample.service;

import com.example.rabbitmqexample.config.RabbitMQProperties;
import com.example.rabbitmqexample.core.CommentEntity;
import com.example.rabbitmqexample.core.ICommentService;
import com.example.rabbitmqexample.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQConsumer {
    private final ICommentService commentService;

    @RabbitListener(queues = RabbitMQProperties.queueName)
    public void receiveMessageFromQueue(Comment comment) {
        CommentEntity commentEntity = new CommentEntity();
        BeanUtils.copyProperties(comment, commentEntity);
        commentService.save(commentEntity);
        System.out.println("Comment was successfully saved in database -> " + commentEntity.getId());
    }
}
