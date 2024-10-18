package com.Recettes.recettes.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {
    @Id
    private ObjectId commentId;
    private String userId;
    private String content;
    private String date;

    public Comment() {}

    public Comment(String userId, String content, String date) {
        this.userId = userId;
        this.content = content;
        this.date = date;
    }

    public ObjectId getCommentId() {
        return commentId;
    }

    public void setCommentId(ObjectId commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
