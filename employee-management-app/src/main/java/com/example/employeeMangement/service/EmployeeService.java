// PACKAGE
package com.example.employeeMangement.service;

// IMPORTS
import com.example.employeeMangement.entity.Employee;
import java.util.List;

// Used for displaying what are the SERVICES are in this application
public interface EmployeeService
{

    List<Employee> getAllEmployees(); // Retrieves a list of all employee records from the database

    boolean deleteEmployeeById(long id); // Deletes the employee record associated with the specified ID from the database

    Employee saveEmployee(Employee employee); // Saves a new employee record to the database

    Employee updateEmployee(Employee employee, long id); // Updates the existing employee record with the specified ID using the provided employee data

    Employee getEmployeeById(long id); // Retrieves the employee record associated with the specified ID from the database
}
