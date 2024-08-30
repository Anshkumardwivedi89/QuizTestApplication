package com.quiztest.QuizTestApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback {

    @Id


    private String gmailId; // This will be the primary key, storing the user's Gmail ID or username.

    private String comment;
    private int rating;

    // Optionally, you can also store the username separately if needed
    private String username;

    // Constructors
    public Feedback() {
    }

    public Feedback(String gmailId, String comment, int rating, String username) {
        this.gmailId = gmailId;
        this.comment = comment;
        this.rating = rating;
        this.username = username;
    }

    // Getters and Setters
    public String getGmailId() {
        return gmailId;
    }

    public void setGmailId(String gmailId) {
        this.gmailId = gmailId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}