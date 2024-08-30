package com.quiztest.QuizTestApplication.controller;


import com.quiztest.QuizTestApplication.entity.Quiz;
import com.quiztest.QuizTestApplication.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/add-new-quiz")
    public ResponseEntity <Quiz> createQuiz(@RequestBody Quiz quiz){
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return ResponseEntity.status(CREATED).body(createdQuiz);
    }

    @GetMapping("/all-quizzes")
    public ResponseEntity <List<Quiz>> getAllQuestions(){
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    @DeleteMapping("/delete-quiz/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-quiz/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        Quiz quiz = quizService.updateQuiz(id, updatedQuiz);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuestionByID(@PathVariable Long id){
        Quiz quiz=quizService.getQuizByID(id);
        return ResponseEntity.ok(quiz);
    }


}
