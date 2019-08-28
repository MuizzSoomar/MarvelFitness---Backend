package com.marvelfitness.portal.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(1, "Kevin Feige", "kevin.feige@mailinator.com", "password1"),
            new Employee(2, "Stan Lee", "stan.lee@mailinator.com", "password2")
    ));

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmployee(int employee_id){
        return employeeRepository.findById(employee_id).orElse(null);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee, int employee_id) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int employee_id) {
        employeeRepository.deleteById(employee_id);
    }
}
