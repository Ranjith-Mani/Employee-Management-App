// PACKAGE
package com.example.employeeMangement.controller;

// IMPORTS
import com.example.employeeMangement.entity.Employee;
import com.example.employeeMangement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// ANNOTATIONS
@Controller // An ANNOTATION in Spring Boot designates a class to handle HTTP requests and return views
@RequestMapping("/employees") // Common mapping for all employee-related endpoints
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired // An ANNOTATION that injects dependencies automatically in Spring Boot
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get all employees") // An ANNOTATION adds documentation details for a REST API endpoint in Swagger
    @GetMapping // GET /employees
    public String getAllEmployees(Model model) {
        List<Employee> result = employeeService.getAllEmployees();
        model.addAttribute("employees", result);
        return "employees-list"; // Thymeleaf template for listing employees
    }

    @Operation(summary = "Load add employee page")
    @GetMapping("/add") // GET /employees/add
    public String loadAddEmployeePage(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee"; // Thymeleaf template for adding an employee
    }

    @Operation(summary = "Save new employee")
    @PostMapping("/save") // POST /employees/save
    public String saveEmployee(@ModelAttribute("employee") Employee emp) {
        employeeService.saveEmployee(emp);
        return "redirect:/employees"; // Redirect after saving
    }

    @Operation(summary = "Load update form")
    @GetMapping("/update/{id}") // GET /employees/update/{id}
    public String loadUpdateForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id); // Prefer using service
        if (employee == null) {
            return "error"; // Handle employee not found
        }
        model.addAttribute("employee", employee);
        return "update-employee"; // Thymeleaf template for updating an employee
    }

    @Operation(summary = "Update employee info")
    @PostMapping("/update/{id}") // POST /employees/update/{id}
    public String updateEmployeeInfo(@ModelAttribute("employee") Employee emp, @PathVariable("id") long id) {
        employeeService.updateEmployee(emp, id);
        return "redirect:/employees"; // Redirect after updating
    }

    @Operation(summary = "Delete employee")
    @PostMapping("/delete/{id}") // POST /employees/delete/{id}
    public String deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees"; // Redirect after deletion
    }


    @Operation(summary = "Get employee details")
    @GetMapping("/details/{id}") // GET /employees/details/{id}
    public String getEmployeeDetails(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee-details"; // Thymeleaf template for employee details
        } else {
            return "error"; // Handle employee not found
        }
    }
}
