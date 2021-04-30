package com.example.springbootdemo.dao;

import com.example.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getEmployee(int id);
    List<Employee> getEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(final Employee employee);
    void deleteEmployee(int id);
}
