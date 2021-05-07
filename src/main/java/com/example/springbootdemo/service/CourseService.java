package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;

import java.util.List;


public interface CourseService {

    List<Course> getAllCourse();
    List<Course> getCourseByStudentName(String studentName);
    Course getCourse(int id);
}
