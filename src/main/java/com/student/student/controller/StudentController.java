package com.student.student.controller;

import com.student.student.entity.StudentEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<StudentEntity> students = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<StudentEntity>> useRequestParam(@RequestParam String name, @RequestParam int age) {
        StudentEntity studentEntity = new StudentEntity(name, age);
        students.add(studentEntity);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<StudentEntity>> useRequestBody(@RequestBody StudentEntity student) {
        students.add(student);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/{name}/{age}")
    public ResponseEntity<List<StudentEntity>> usePathVariable(@PathVariable String name, @PathVariable int age) {
        StudentEntity studentEntity = new StudentEntity(name, age);
        students.add(studentEntity);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}