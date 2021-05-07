package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();
    List<Student> getStudentByCourseName(String courseName);
    Student findStudentById(int id);
}
