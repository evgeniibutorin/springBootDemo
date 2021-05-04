package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(int id);
    List<Employee> getEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> deleteSimilarEmployees();
    List<Employee> findEmployeeByName(String name);
}
