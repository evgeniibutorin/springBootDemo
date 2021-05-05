package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.model.Tag;
import com.example.springbootdemo.service.EmployeeService;
import com.example.springbootdemo.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TagController {

    private final EmployeeService employeeService;
    private final TagService tagService;

    public TagController(EmployeeService employeeService, TagService tagService) {
        this.employeeService = employeeService;
        this.tagService = tagService;
    }

    @GetMapping("teg/{id}")
    public String updatePage(@PathVariable("id") int id, ModelMap tagModel) {
        //employeeModel.addAttribute("employee_id", id);
        Employee employee = employeeService.getEmployee(id);
        List<Tag> tags = tagService.getTagsByEmployeeId(id);
        tagModel.addAttribute("tags", tags);
        tagModel.addAttribute("employee", employee);
        return "teg";
    }

    @PostMapping("/add/{id}")
    public String addEmployee(@RequestParam(value = "tag", required = true) String tagName,
                              @PathVariable("id") int employee_id,
                              ModelMap tagModel) {
        Employee employee = employeeService.getEmployee(employee_id);
        Tag tag = new Tag();
        tag.setTag(tagName);
        tag.setEmployee(employee);
        tagService.addTag(tag);
        tagModel.addAttribute("msg", "Employee added successfully");
        List<Tag> tags = tagService.getTagsByEmployeeId(employee_id);
        tagModel.addAttribute("tags", tags);
        tagModel.addAttribute("employee", employee);
        return "teg";
    }

    @GetMapping("/delete/{employee_id}/tag/{id}")
    public String deleteTag(@PathVariable("id") int id,@PathVariable("employee_id") int employee_id, ModelMap tagModel) {
        tagService.deleteTag(id);
        Employee employee = employeeService.getEmployee(employee_id);
        List<Tag> tags = tagService.getTagsByEmployeeId(employee_id);
        tagModel.addAttribute("tags", tags);
        tagModel.addAttribute("employee", employee);
        return "teg";
    }

    @GetMapping("/update/tag/{id}")
    public String updateTag(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("id", id);
        Tag tag = tagService.getTag(id);
        modelMap.addAttribute("tag", tag);
        return "updateTag";
    }

    @PostMapping("/update/tag")
    public String updateTag(@RequestParam("id") int id, @RequestParam(value = "tag", required = true) String tagName,
                                 ModelMap tagModel) {
        Employee employee = tagService.getTag(id).getEmployee();
        Tag oldTag = tagService.getTag(id);
        oldTag.setTag(tagName);
        tagService.updateTag(oldTag);
        List<Tag> tags = tagService.getTagsByEmployeeId(employee.getId());
        tagModel.addAttribute("tags", tags);
        tagModel.addAttribute("employee", employee);
        return "teg";
    }

}
