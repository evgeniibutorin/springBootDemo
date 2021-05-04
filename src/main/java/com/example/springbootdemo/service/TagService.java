package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TagService {

    Tag getTag(int id);
    void addTag(Tag tag);
    void updateTag(Tag tag);
    void deleteTag(int id);
    List<Tag> getTagsByEmployeeId(int id);


}
