package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.create(student));
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> read(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.read(id));
    }

    @PutMapping("update")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.delete(id));
    }


    @GetMapping
    public ResponseEntity<Collection<Student>> printAllStudents() {
        return ResponseEntity.ok(studentService.printAllStudents());
    }

    @GetMapping("filter")
    public ResponseEntity<Collection<Student>> filterByAge(@RequestParam Integer age) {
        return ResponseEntity.ok(studentService.filterByAge(age));
    }
}
