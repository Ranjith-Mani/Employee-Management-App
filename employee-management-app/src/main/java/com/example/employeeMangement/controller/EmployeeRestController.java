// PACKAGE
package com.example.employeeMangement.controller;

// IMPORTS
import com.example.employeeMangement.entity.Employee;
import com.example.employeeMangement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get all employees")
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @Operation(summary = "Save a new employee")
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
        Employee savedEmployee = employeeService.saveEmployee(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @Operation(summary = "Get employee details")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeDetails(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Update employee info")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeInfo(@RequestBody Employee emp, @PathVariable("id") long id) {
        Employee updatedEmployee = employeeService.updateEmployee(emp, id);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Delete employee")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id) {
        boolean isDeleted = employeeService.deleteEmployeeById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
