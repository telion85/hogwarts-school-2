package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private static Long counterId;

    public Faculty create(String name, String color) {
        return facultyMap.put(counterId, new Faculty(counterId++, name, color));
    }

    public Faculty read(Long facultyId) {
        return facultyMap.get(facultyId);
    }

    public Faculty update(Long facultyId, String name, String color) {
        Faculty faculty = facultyMap.get(facultyId);
        faculty.setName(name);
        faculty.setColor(color);
        return facultyMap.put(facultyId, faculty);
    }

    public Faculty delete(Long facultyId) {
        return facultyMap.remove(facultyId);
    }

    public List<Faculty> filterByColor(String color) {
        return facultyMap.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
