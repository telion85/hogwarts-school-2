package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> repositoryMap = new HashMap<>();
    private static Long counterId = 1L;
    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public Student create(Student student) {
        return repositoryMap.put(counterId++, student);
    }

    public Student read(Long studentId) {
        return repositoryMap.get(studentId);
    }

    public Student update(Long studentId, Student student) {
        return repositoryMap.put(studentId, student);
    }

    public Student delete(Long studentId) {
        return repositoryMap.remove(studentId);
    }





}
