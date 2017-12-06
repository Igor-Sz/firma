package com.firma.pracownicy.controller;


import java.util.*;
import com.firma.pracownicy.domain.Employee;
import com.firma.pracownicy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/rest") public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody void add(@RequestBody Employee employee) {
        employeeService.add(employee);
    }

    @RequestMapping(value = "/remove/{employeeId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable(value = "employeeId") int employeeId) {
        employeeService.removeEmployee(employeeId);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public @ResponseBody List<Employee> pullEmployees() {
        return employeeService.pullEmployees();
    }

    @RequestMapping(value = "/employee/pick/{filter}", method = RequestMethod.GET)
    public @ResponseBody List<Employee> pullEmployeesByFilter(@MatrixVariable Map<String, List<String>> filterParams) {
        return employeeService.pullEmployeesByFilter(filterParams);
    }

    @RequestMapping(value = "/employee/{employeeID}", method = RequestMethod.GET)
    public @ResponseBody Employee pullEmployee(@PathVariable(value = "employeeID") int employeeId) {
        return employeeService.pullEmployee(employeeId);
    }
}