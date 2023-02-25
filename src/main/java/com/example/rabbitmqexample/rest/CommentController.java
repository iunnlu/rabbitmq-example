package com.example.rabbitmqexample.rest;

import com.example.rabbitmqexample.core.ICommentService;
import com.example.rabbitmqexample.model.Comment;
import com.example.rabbitmqexample.service.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {
    private final RestTemplate restTemplate;
    private final RabbitMQProducer rabbitMQProducer;

    @GetMapping()
    public String getComments() {
        Comment[] comments = this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments", Comment[].class);
        List<Comment> commentList = List.of(comments);
        for(Comment comment: commentList.stream().limit(10).collect(Collectors.toList())){
            try{
                rabbitMQProducer.addMessageToQueue(comment);
            } catch (Exception e) {
                return e.getMessage();
            }
        }
        return "Data was successfully added queue";
    }
}
