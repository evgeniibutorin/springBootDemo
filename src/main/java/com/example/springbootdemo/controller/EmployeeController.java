package com.example.springbootdemo.controller;

import com.example.springbootdemo.dao.EmployeeDao;
import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable int id, ModelMap employeeModel) {
        Employee employee = employeeService.getEmployee(id);
        employeeModel.addAttribute("employee", employee);
        return "employee";
    }

    @GetMapping("/employees")
    public String getEmployees(ModelMap employeeModel) {
        List<Employee> employees = employeeService.getEmployees();
        employeeModel.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("addEmployee")
    public String addPage() {
        return "add";
    }

    @PostMapping("/add/employee")
    public String addEmployee(@RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "position", required = true) String position, ModelMap employeeModel) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employeeService.addEmployee(employee);
        employeeModel.addAttribute("msg", "Employee added successfully");
        List<Employee> employees = employeeService.getEmployees();
        employeeModel.addAttribute("employees", employees);
        return "redirect:/employees";
    }

    @GetMapping("update/employee/{id}")
    public String updatePage(@PathVariable("id") int id, ModelMap employeeModel) {
        employeeModel.addAttribute("id", id);
        Employee employee = employeeService.getEmployee(id);
        employeeModel.addAttribute("employee", employee);
        return "update";
    }

    @PostMapping("/update/employee")
    public String updateEmployee(@RequestParam int id, @RequestParam(value = "name", required = true) String name,
                                 @RequestParam(value = "position", required = true) String position, ModelMap employeeModel) {
        Employee employee = new Employee(id,name,position);
        /*
         * employee.setId(id); employee.setName(name); employee.setPosition(position);
         */
        employeeService.updateEmployee(employee);
        List<Employee> employees = employeeService.getEmployees();
        employeeModel.addAttribute("employees", employees);
        employeeModel.addAttribute("id", id);
        employeeModel.addAttribute("msg", "Employee updated successfully");
        return "redirect:/employees";
    }

    @GetMapping("/delete/employee/{id}")
    public String deleteEmployee(@PathVariable int id, ModelMap employeeModel) {
        employeeService.deleteEmployee(id);
        List<Employee> employees = employeeService.getEmployees();
        employeeModel.addAttribute("employees", employees);
        employeeModel.addAttribute("msg", "Employee delted successfully");
        return "redirect:/employees";
    }

}
