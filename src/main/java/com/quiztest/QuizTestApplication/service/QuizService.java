package com.quiztest.QuizTestApplication.service;

import com.quiztest.QuizTestApplication.entity.Quiz;
import com.quiztest.QuizTestApplication.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizService{

    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
        Quiz existingQuiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        existingQuiz.setQuestion(updatedQuiz.getQuestion());
        existingQuiz.setSubject(updatedQuiz.getSubject());
        existingQuiz.setQuestionType(updatedQuiz.getQuestionType());
        existingQuiz.setChoices(updatedQuiz.getChoices());
        existingQuiz.setCorrectChoice(updatedQuiz.getCorrectChoice());
        return quizRepository.save(existingQuiz);
    }

    public Quiz getQuizByID(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz not found"));
        return quiz;
    }



}
