package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private static Long counterId = 1L;

    public Student create(String name, Integer age) {
        return studentMap.put(counterId, new Student(counterId++, name, age));
    }

    public Student read(Long studentId) {
        return studentMap.get(studentId);
    }

    public Student update(Long studentId, String name, Integer age) {
        Student student = studentMap.get(studentId);
        student.setName(name);
        student.setAge(age);
        return student;
    }

    public Student delete(Long studentId) {
        return studentMap.remove(studentId);
    }

    public List<Student> filterByAge(Integer age) {
        return studentMap.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
}