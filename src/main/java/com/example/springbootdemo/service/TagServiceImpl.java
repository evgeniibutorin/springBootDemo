package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Tag;
import com.example.springbootdemo.repository.EmployeeRepository;
import com.example.springbootdemo.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    public TagServiceImpl(EmployeeRepository employeeRepository, TagRepository tagRepository) {
        this.employeeRepository = employeeRepository;
        this.tagRepository = tagRepository;
    }

    EmployeeRepository employeeRepository;
    TagRepository tagRepository;

    @Override
    public Tag getTag(int id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public void addTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void deleteTag(int id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<Tag> getTagsByEmployeeId(int id) {
        List<Tag> tags = tagRepository.findTagsByEmployee_Id(id);
        return tags;
    }

}
