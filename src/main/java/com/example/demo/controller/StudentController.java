package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/main")
public class StudentController {

    private static List<Student> STUDENTS= Arrays.asList(new Student("Vova", 1),
            new Student("Alina", 2),
            new Student("Vladick", 3),
            new Student("vasya", 4));

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer id){
        return STUDENTS.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst().orElseThrow(()->new IllegalStateException("Student "+ id + " does not exists"));
    }
}
