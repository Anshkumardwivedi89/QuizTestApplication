package com.quiztest.QuizTestApplication.controller;

import com.quiztest.QuizTestApplication.entity.Feedback;
import com.quiztest.QuizTestApplication.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{gmailId}")
    public Optional<Feedback> getFeedbackByGmailId(@PathVariable String gmailId) {
        return feedbackService.getFeedbackByGmailId(gmailId);
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.createFeedback(feedback);
    }

    @PutMapping("/{gmailId}")
    public Feedback updateFeedback(@PathVariable String gmailId, @RequestBody Feedback updatedFeedback) {
        return feedbackService.updateFeedback(gmailId, updatedFeedback);
    }

    @DeleteMapping("/{gmailId}")
    public void deleteFeedback(@PathVariable String gmailId) {
        feedbackService.deleteFeedback(gmailId);
    }
}