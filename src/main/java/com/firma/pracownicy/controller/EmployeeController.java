package com.firma.pracownicy.controller;

import com.firma.pracownicy.domain.Employee;
import com.firma.pracownicy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add")
    public @ResponseBody void add(@RequestBody Employee employee) {
        employeeService.add(employee);
    }

    @RequestMapping(value = "/remove/{employeeId}")
    public void remove(@PathVariable(value = "employeeId") int employeeId) {
        employeeService.removeEmployee(employeeId);
    }

    @RequestMapping(value = "/employees",  method = RequestMethod.GET)
    public String pullEmployees(Model model) {
        return "employees";
    }

    @RequestMapping(value = "/employee/pick/{filter}")
    public @ResponseBody List<Employee> pullEmployeesByFilter(@MatrixVariable Map<String, List<String>> filterParams) {
        return employeeService.pullEmployeesByFilter(filterParams);
    }

    @RequestMapping(value = "/employee/{employeeID}")
    public String pullEmployee(@PathVariable(value = "employeeID") int employeeId, Model model) {
        model.addAttribute("empno", employeeId);
        return "employees";
    }
}