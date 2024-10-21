package com.Recettes.recettes.service;

import com.Recettes.recettes.model.Comment;
import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    List<Comment> getCommentsByUserId(String userId);
}
