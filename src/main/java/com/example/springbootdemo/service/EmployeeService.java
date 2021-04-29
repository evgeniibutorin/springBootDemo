package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.EmployeeDao;
import com.example.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;


    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee getEmployee(final int id) {
        return employeeDao.getEmployee(id);
    }

    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    public void addEmployee(final Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void updateEmployee(final Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(final int id) {
        employeeDao.deleteEmployee(id);
    }


}
