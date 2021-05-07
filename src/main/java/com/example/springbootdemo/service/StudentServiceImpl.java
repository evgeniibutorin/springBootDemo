package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;
import com.example.springbootdemo.repository.CourseRepository;
import com.example.springbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentByCourseName(String courseName) {
        return studentRepository.findStudentsByCoursesName(courseName);
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findById(id).get();
    }

}
