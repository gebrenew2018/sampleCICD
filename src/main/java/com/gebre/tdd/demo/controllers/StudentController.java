package com.gebre.tdd.demo.controllers;

import com.gebre.tdd.demo.models.Student;
import com.gebre.tdd.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}
