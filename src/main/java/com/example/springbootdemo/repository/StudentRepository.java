package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select s.* from student s " +
            "join student_course s2c on s.id = s2c.student_id " +
            "join course c ON s2c.course_id = c.id " +
            "where c.course_name =:name",nativeQuery = true)
    List<Student> findStudentsByCoursesName1(@Param("name") String name);

//    @Query(value = "select s from student s " +
//            "join student_course s2c on s.id = s2c.student_id " +
//            "join course c ON s2c.course_id = c.id " +
//            "where c.course_name =:name")
//    List<Student> findStudentsByCoursesName(@Param("name") String name);



    @Query(value = "select s from Student s inner join s.courses c where c.courseName = ?1")
    List<Student> findStudentsByCoursesName(String name);

}
