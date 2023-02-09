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

    public Student create(Student student) {
        return studentMap.put(counterId++, student);
    }

    public Student read(Long studentId) {
        return studentMap.get(studentId);
    }

    public Student update(Student student) {
        Student currentStudent = studentMap.get(student.getId());
        currentStudent.setName(student.getName());
        currentStudent.setAge(student.getAge());
        return currentStudent;
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