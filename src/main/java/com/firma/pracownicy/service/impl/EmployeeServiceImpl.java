package com.firma.pracownicy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import com.firma.pracownicy.domain.Employee;
import com.firma.pracownicy.repository.EmployeeRepository;
import com.firma.pracownicy.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        employeeRepository.setJdbcTemplate(jdbcTemplate);
    }

    public int insertEmployee(Employee e) {
        return employeeRepository.insertEmployee(e);
    }

    public int removeEmployee(int ID) {
        return employeeRepository.removeEmployee(ID);
    }

    public Employee pullEmployee(int ID) {
        return employeeRepository.pullEmployee(ID);
    }

    public void add(Employee employee) {
        employeeRepository.add(employee);
    }

    public List<Employee> pullEmployees() {
        return employeeRepository.pullEmployees();
    }

    public List<Employee> pullEmployeesByFilter(Map<String, List<String>> filterParams) {
        return employeeRepository.pullEmployeesByFilter(filterParams);
    }

}
