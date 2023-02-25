package com.example.rabbitmqexample.config;

import com.example.rabbitmqexample.model.Comment;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(Comment comment) {
        System.out.println("Received <" + comment.toString() + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
