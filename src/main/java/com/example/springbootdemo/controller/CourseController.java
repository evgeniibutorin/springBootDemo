package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public String getCourses(ModelMap courseModel){
        List<Course> list = courseService.getAllCourse();
        courseModel.addAttribute("courses", list);
        return "course";
    }

    @GetMapping("/courses/find")
    public String getCoursesByStudentName(@RequestParam(value = "name") String name, ModelMap courseModel){
        List<Course> list = courseService.getCourseByStudentName(name);
        courseModel.addAttribute("courses", list);
        return "course";
    }
}
