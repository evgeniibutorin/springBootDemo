package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;
import com.example.springbootdemo.repository.CourseRepository;
import com.example.springbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getCourseByStudentName(String studentName) {
        return courseRepository.findCoursesByStudentName(studentName);
    }

    @Override
    public Course getCourse(int id){
        return courseRepository.findById(id).get();
    }
}
