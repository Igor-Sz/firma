package com.firma.pracownicy.repository.impl;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.lang.StringBuffer;

import org.springframework.jdbc.core.JdbcTemplate;
import com.firma.pracownicy.domain.Employee;
import com.firma.pracownicy.repository.EmployeeRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertEmployee(Employee e){
        String query="insert into emp values('"+e.getEmployeeID()+"','"+e.getName()+"','"+e.getSurname()+"','"+e.getPosition()+"','"+e.getEmail()+"')";
        return jdbcTemplate.update(query);
    }

    public int removeEmployee(int ID){
        String query="DELETE FROM emp WHERE Empno='"+ID+"' ";
            jdbcTemplate.update(query);
        return 0;
    }
    public void add(Employee employee){
        String query="INSERT INTO emp VALUES('" + employee.getEmployeeID() + "', '" + employee.getName() + "', '" + employee.getSurname() + "', '" + employee.getEmail() + "', '" + employee.getPosition()+ "');";
        jdbcTemplate.update(query);
    }


    public Employee pullEmployee(int ID) {
        String sqlquery="SELECT * FROM emp WHERE Empno='" + ID + "'";
        Employee employee = jdbcTemplate.queryForObject(sqlquery, new RowMapper<Employee>() {

            public Employee mapRow(ResultSet result, int rowNum) throws SQLException {
                Employee emp = new Employee();
                emp.setEmployeeID((result.getInt(1)));
                emp.setName(result.getString(2));
                emp.setSurname(result.getString(3));
                emp.setEmail(result.getString(4));
                emp.setPosition(result.getInt(5));
                return emp;
            }
        });
        return employee;
    }

    public List<Employee> pullEmployees() {
        String sqlquery = "SELECT * FROM emp";
        List<Employee> listEmployee = jdbcTemplate.query(sqlquery, new RowMapper<Employee>() {

            public Employee mapRow(ResultSet result, int rowNum) throws SQLException {
                Employee emp = new Employee();
                emp.setEmployeeID((result.getInt(1)));
                emp.setName(result.getString(2));
                emp.setSurname(result.getString(3));
                emp.setEmail(result.getString(4));
                emp.setPosition(result.getInt(5));
                return emp;
            }
        });
        return listEmployee;
    }

    public List<Employee> pullEmployeesByFilter(Map<String, List<String>> filterParams) {
        StringBuffer sqlquery = new StringBuffer();
        boolean other = false;
        String query;
        sqlquery.append("SELECT * FROM emp WHERE ");
        String name, surname, email;
        if (filterParams.containsKey("name")) {
            if (other) sqlquery.append(" OR ");
            sqlquery.append("NAME LIKE '" + filterParams.get("name").get(0));
            if (filterParams.get("name").size() > 1) {
                for (int i = 1; i < filterParams.get("name").size(); i++)
                    sqlquery.append("' OR '" + filterParams.get("name").get(i));
            }
            sqlquery.append("'");
            other = true;
        }
        if (filterParams.containsKey("surname")) {
            if (other) sqlquery.append(" OR ");
            sqlquery.append("SURNAME LIKE '" + filterParams.get("surname").get(0));
            if (filterParams.get("surname").size() > 1) {
                for (int i = 1; i < filterParams.get("surname").size(); i++)
                    sqlquery.append("' OR '" + filterParams.get("surname").get(i));
            }
            sqlquery.append("'");
            other = true;
        }
        if (filterParams.containsKey("position")) {
            if (other) sqlquery.append(" OR ");
            sqlquery.append("POSNO LIKE '" + filterParams.get("position").get(0));
            if (filterParams.get("position").size() > 1) {
                for (int i = 1; i < filterParams.get("position").size(); i++)
                    sqlquery.append("' OR '" + filterParams.get("position").get(i));
            }
            sqlquery.append("'");
        }
        sqlquery.append(";");
        query = sqlquery.toString();
        System.out.println(query);
        List<Employee> listEmployee = jdbcTemplate.query(query, new RowMapper<Employee>() {

            public Employee mapRow(ResultSet result, int rowNum) throws SQLException {
                Employee emp = new Employee();
                emp.setEmployeeID((result.getInt(1)));
                emp.setName(result.getString(2));
                emp.setSurname(result.getString(3));
                emp.setEmail(result.getString(4));
                emp.setPosition(result.getInt(5));
                return emp;
            }
        });
        return listEmployee;
    }

}
