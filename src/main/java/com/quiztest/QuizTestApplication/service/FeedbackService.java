package com.quiztest.QuizTestApplication.service;

import com.quiztest.QuizTestApplication.entity.Feedback;
import com.quiztest.QuizTestApplication.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackByGmailId(String gmailId) {
        return feedbackRepository.findById(gmailId);
    }

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback(String gmailId, Feedback updatedFeedback) {
        return feedbackRepository.findById(gmailId)
                .map(feedback -> {
                    feedback.setComment(updatedFeedback.getComment());
                    feedback.setRating(updatedFeedback.getRating());
                    feedback.setUsername(updatedFeedback.getUsername());
                    return feedbackRepository.save(feedback);
                })
                .orElseThrow(() -> new RuntimeException("Feedback not found with Gmail ID " + gmailId));
    }

    public void deleteFeedback(String gmailId) {
        feedbackRepository.deleteById(gmailId);
    }
}