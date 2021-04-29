package com.example.springbootdemo.config;

import com.example.springbootdemo.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int row) throws SQLException {
        return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("position"));
    }

}
