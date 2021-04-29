package com.example.springbootdemo.dao;
import com.example.springbootdemo.config.EmployeeRowMapper;
import com.example.springbootdemo.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public List<Employee> list(){
//        String sql ="SELECT * FROM employees";
//        List<Employee> employeeList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
//        return employeeList;
//    }

    public Employee getEmployee(final int id) {
        Employee employee = jdbcTemplate.queryForObject("select * from employee where id = ?", new Object[] { id },
                new EmployeeRowMapper());
        return employee;
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
        return employees;
    }

    public void addEmployee(final Employee employee) {
        jdbcTemplate.update("insert into employee(name, position ) values(?, ?)",
                new Object[] { employee.getName(), employee.getPosition() });
    }

    public void updateEmployee(final Employee employee) {
        jdbcTemplate.update("update employee set name = ?, position = ? where id = ?",
                new Object[] { employee.getName(), employee.getPosition(), employee.getId() });
    }

    public void deleteEmployee(final int id) {
        jdbcTemplate.update("delete from employee where id = ?", new Object[] { id });
    }

}
