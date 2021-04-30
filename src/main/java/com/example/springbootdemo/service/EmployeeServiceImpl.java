package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.EmployeeDao;
import com.example.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getEmployee(final int id) { return getEmployeeDao().getEmployee(id); }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    @Transactional(readOnly = false)
    public void addEmployee(final Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateEmployee(final Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteEmployee(final int id) { employeeDao.deleteEmployee(id); }

}
