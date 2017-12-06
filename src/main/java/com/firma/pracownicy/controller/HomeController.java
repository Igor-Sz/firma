package com.firma.pracownicy.controller;
import com.firma.pracownicy.service.EmployeeService;
import com.firma.pracownicy.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class HomeController {
    private SimpleDriverDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;

    @RequestMapping("/")
    public String index() throws SQLException {
        dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new com.mysql.jdbc.Driver());
        dataSource.setUrl("jdbc:mysql://localhost/firma");
        dataSource.setUsername("firma");
        dataSource.setPassword("test123");
        jdbcTemplate = new JdbcTemplate(dataSource);
        employeeService.setJdbcTemplate(jdbcTemplate);
        positionService.setJdbcTemplate(jdbcTemplate);
        return "index";
    }
}