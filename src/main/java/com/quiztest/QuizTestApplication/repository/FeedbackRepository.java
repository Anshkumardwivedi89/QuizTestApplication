package com.quiztest.QuizTestApplication.repository;

import com.quiztest.QuizTestApplication.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {
    Optional<Feedback> findById(String gmailId);
}