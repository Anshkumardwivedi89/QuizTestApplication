package com.quiztest.QuizTestApplication.controller;

import com.quiztest.QuizTestApplication.entity.Subject;
import com.quiztest.QuizTestApplication.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/subjects")
@RestController
@RequiredArgsConstructor
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/add-new-subject")
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.addSubject(subject);
        return ResponseEntity.status(CREATED).body(createdSubject);
    }

    @GetMapping("/all-subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

}
