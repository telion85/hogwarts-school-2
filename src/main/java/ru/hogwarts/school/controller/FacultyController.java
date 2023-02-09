package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("create")
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.create(faculty));
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> read(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.read(id));
    }

    @PutMapping("update")
    public ResponseEntity<Faculty> update(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.update(faculty));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> delete(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.delete(id));
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> printAllFaculties() {
        return ResponseEntity.ok(facultyService.printAllFaculties());
    }

    @GetMapping("filter")
    public ResponseEntity<Collection<Faculty>> filterByColor(@RequestParam String color) {
        return ResponseEntity.ok(facultyService.filterByColor(color));
    }
}
