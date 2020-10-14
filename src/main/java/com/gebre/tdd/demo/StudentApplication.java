package com.gebre.tdd.demo;

import com.gebre.tdd.demo.models.Student;
import com.gebre.tdd.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class);
    }
    @Bean
    public CommandLineRunner sampleData(StudentRepository repository){
        return (args -> {
           repository.save(new Student("Gebre",32,"Computer Science"));
           repository.save(new Student("Abebe",32,"Computer Science"));
           repository.save(new Student("John",32,"Computer Science"));
        });
    }
}
