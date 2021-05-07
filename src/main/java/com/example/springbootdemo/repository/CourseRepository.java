package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Course;
import com.example.springbootdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "select c.* from course c " +
            "join student_course s2c on c.id = s2c.course_id " +
            "join student s ON s2c.student_id = s.id " +
            "where s.student_name =:name", nativeQuery = true)
    List<Course> findCoursesByStudentName2(@Param("name") String name);


    @Query(value = "select c from Course c inner join c.students s where s.studentName =:name")
    List<Course> findCoursesByStudentName(@Param("name") String name);
}


