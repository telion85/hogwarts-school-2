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

    public Faculty create(Faculty faculty) {
        Faculty newFaculty = new Faculty(counterId, faculty.getName(), faculty.getColor());
        facultyMap.put(counterId++, newFaculty);
        return newFaculty;
    }

    public Faculty read(Long facultyId) {
        return facultyMap.get(facultyId);
    }

    public Faculty update(Faculty faculty) {
        Faculty currentFaculty = facultyMap.get(faculty.getId());
        if (null == currentFaculty) return null;
        currentFaculty.setName(faculty.getName());
        currentFaculty.setColor(faculty.getColor());
        return currentFaculty;
    }

    public Faculty delete(Long facultyId) {
        return facultyMap.remove(facultyId);
    }

    public List<Faculty> filterByColor(String color) {
        return facultyMap.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }

    public List<Faculty> printAllFaculties() {
        return facultyMap.values().stream()
                .toList();
    }
}
