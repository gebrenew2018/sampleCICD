package com.gebre.tdd.demo.repository;

import com.gebre.tdd.demo.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    List<Student> findByName(String name);
}
