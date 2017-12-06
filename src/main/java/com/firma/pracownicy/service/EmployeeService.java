package com.firma.pracownicy.service;

import com.firma.pracownicy.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    public int insertEmployee(Employee e);
    public int removeEmployee(int ID);
    public void add(Employee employee);
    public Employee pullEmployee(int ID);
    public List<Employee> pullEmployees();
    public List<Employee> pullEmployeesByFilter(Map<String, List<String>> filterParams);
}
