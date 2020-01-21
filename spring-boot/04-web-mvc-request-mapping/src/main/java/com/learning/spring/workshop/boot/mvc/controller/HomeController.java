package com.learning.spring.workshop.boot.mvc.controller;

import com.learning.spring.workshop.boot.mvc.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class HomeController {
    @GetMapping
    public @ResponseBody
    String index() {
        return "Hello VelTech Students";
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Student byId(@PathVariable long id) {
        return new Student(id, "Gandhi", 21);
    }

    @PostMapping
    public ResponseEntity<Student> post(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        return new ResponseEntity<>("Student with id " + id + " deleted.", HttpStatus.OK);
    }
}


// curl -i -X POST -H "Content-Type: application/json" -d '{"id":20,"name":"Sukanya", "age":55}' http://localhost:8080/student/