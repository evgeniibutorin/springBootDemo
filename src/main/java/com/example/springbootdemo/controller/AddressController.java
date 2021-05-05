package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Employee;
import com.example.springbootdemo.model.Tag;
import com.example.springbootdemo.service.AddressService;
import com.example.springbootdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AddressController {


    private final AddressService addressService;
    private final EmployeeService employeeService;


    public AddressController(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }


    @GetMapping("/add/address/{id}")
    public String updatePage(@PathVariable("id") int employeeId, ModelMap addressModel) {
        //employeeModel.addAttribute("employee_id", id);
        Employee employee = employeeService.getEmployee(employeeId);
        addressModel.addAttribute("employee", employee);
        return "addAddress";
    }
}
