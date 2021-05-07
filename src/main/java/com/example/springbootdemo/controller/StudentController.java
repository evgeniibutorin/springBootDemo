package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;
import com.example.springbootdemo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getStudents(ModelMap studentModel){
        List<Student> students = studentService.getAllStudent();
        studentModel.addAttribute("students", students);
        return "student";
    }
    @GetMapping("/student/find")
    public String getStudentsByCourse(@RequestParam(value = "name") String name, ModelMap studentModel){
        List<Student> list = studentService.getStudentByCourseName(name);
        studentModel.addAttribute("students", list);
        return "student";
    }


}
