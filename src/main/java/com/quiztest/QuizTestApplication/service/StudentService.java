package com.quiztest.QuizTestApplication.service;

import com.quiztest.QuizTestApplication.entity.Student;
import com.quiztest.QuizTestApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student addStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
