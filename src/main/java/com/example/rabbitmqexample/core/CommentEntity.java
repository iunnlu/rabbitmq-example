package com.example.rabbitmqexample.core;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;
}
