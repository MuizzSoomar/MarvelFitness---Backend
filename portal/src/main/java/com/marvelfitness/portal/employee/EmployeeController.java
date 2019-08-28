package com.marvelfitness.portal.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{employee_id}")
    public Employee getEmployee(@PathVariable int employee_id) {
        return employeeService.getEmployee(employee_id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/employees/{employee_id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable int employee_id) {
        employeeService.updateEmployee(employee, employee_id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/employees/{employee_id}")
    public void deleteEmployee(@PathVariable int employee_id) {
        employeeService.deleteEmployee(employee_id);
    }

}
