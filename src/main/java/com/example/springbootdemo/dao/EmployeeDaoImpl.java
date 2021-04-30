package com.example.springbootdemo.dao;

import com.example.springbootdemo.config.EmployeeRowMapper;
import com.example.springbootdemo.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee getEmployee(final int id) {
        Employee employee = jdbcTemplate.queryForObject("select * from employee where id = ?", new Object[]{id},
                new EmployeeRowMapper());
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
        return employees;
    }

    @Override
    public void addEmployee(final Employee employee) {
        jdbcTemplate.update("insert into employee(name, position ) values(?, ?)",
                new Object[]{employee.getName(), employee.getPosition()});
    }

    @Override
    public void updateEmployee(final Employee employee) {
        jdbcTemplate.update("update employee set name = ?, position = ? where id = ?",
                new Object[]{employee.getName(), employee.getPosition(), employee.getId()});
    }

    @Override
    public void deleteEmployee(final int id) {
        jdbcTemplate.update("delete from employee where id = ?", new Object[]{id});
    }

}
