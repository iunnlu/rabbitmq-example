package com.example.rabbitmqexample.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {
    private final CommentRepository commentRepository;

    @Override
    public void save(CommentEntity comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<CommentEntity> getAll() {
        return commentRepository.findAll();
    }
}
