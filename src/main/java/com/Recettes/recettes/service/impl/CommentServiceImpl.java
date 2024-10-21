package com.Recettes.recettes.service.impl;

import com.Recettes.recettes.model.Comment;
import com.Recettes.recettes.repository.CommentRepository;
import com.Recettes.recettes.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByUserId(String userId) {
        return commentRepository.findByUserId(userId);
    }
}
