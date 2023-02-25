package com.example.rabbitmqexample.core;

import java.util.List;

public interface ICommentService {
    void save(CommentEntity comment);
    List<CommentEntity> getAll();
}
