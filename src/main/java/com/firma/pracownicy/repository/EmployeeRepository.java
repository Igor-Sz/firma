package com.firma.pracownicy.repository;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import com.firma.pracownicy.domain.Employee;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    public int insertEmployee(Employee e);
    public int removeEmployee(int ID);
    public void add (Employee employee);
    public Employee pullEmployee (int ID);
    public List<Employee> pullEmployees();
    public List<Employee> pullEmployeesByFilter(Map<String, List<String>> filterParams);
}