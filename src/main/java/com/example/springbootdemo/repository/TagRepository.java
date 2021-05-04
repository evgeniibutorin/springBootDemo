package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query("SELECT t FROM Tag t WHERE t.employee.id = ?1")
    List<Tag> findTagsByEmployee_Id(Integer id);


}
