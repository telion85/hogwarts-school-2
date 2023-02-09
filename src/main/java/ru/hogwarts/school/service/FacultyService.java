package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private static Long counterId;

    public Faculty create(Faculty faculty) {
        return facultyMap.put(counterId++, faculty);
    }

    public Faculty read(Long facultyId) {
        return facultyMap.get(facultyId);
    }

    public Faculty update(Long facultyId, Faculty faculty) {
        return facultyMap.put(facultyId, faculty);
    }

    public Faculty delete(Long facultyId) {
        return facultyMap.remove(facultyId);
    }
}
