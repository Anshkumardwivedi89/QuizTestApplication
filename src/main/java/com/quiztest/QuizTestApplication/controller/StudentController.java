package com.quiztest.QuizTestApplication.controller;

import com.quiztest.QuizTestApplication.entity.Student;
import com.quiztest.QuizTestApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/save-student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/login")
    public String login(@RequestBody Student student) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(student.getEmail(), student.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "Login successful";
    }

    @GetMapping("/student")
    public Optional<Student> getStudentByEmail(@RequestParam String email) {
        return studentService.findByEmail(email);
    }
}
