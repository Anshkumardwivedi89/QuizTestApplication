package com.quiztest.QuizTestApplication.repository;

import com.quiztest.QuizTestApplication.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository <Quiz, Long> {
}
