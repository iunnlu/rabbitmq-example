package com.example.rabbitmqexample.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Comment implements Serializable {
    private long postId;
    private long id;
    private String name;
    private String email;
    private String body;
}
