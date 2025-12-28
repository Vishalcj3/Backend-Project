package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String content;
    private boolean isInternal;

    @ManyToOne
    private Grievance grievance;

    @ManyToOne
    private User user;

    public Comment() {}

    // getters & setters
    public Long getCommentId() { return commentId; }
    public void setCommentId(Long commentId) { this.commentId = commentId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public boolean getIsInternal() { return isInternal; }
    public void setIsInternal(boolean isInternal) { this.isInternal = isInternal; }

    public Grievance getGrievance() { return grievance; }
    public void setGrievance(Grievance grievance) { this.grievance = grievance; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

