// PACKAGE
package com.example.employeeMangement.service;

// IMPORTS
import com.example.employeeMangement.entity.Employee;
import com.example.employeeMangement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// ANNOTATION
@Service // An ANNOTATION that marks a class as a service component in Spring

public class EmployeeServiceImpl implements EmployeeService
{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    @Override // An ANNOTATION indicates a method overrides a superclass method
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @Override
    public boolean deleteEmployeeById(long id)
    {
        employeeRepository.deleteById(id);
        return false;
    }

    @Override
    public Employee saveEmployee(Employee employee)
    {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee, long id)
    {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent())
        {
            Employee e = existingEmployee.get();
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            e.setEmail(employee.getEmail());
            employeeRepository.save(e);
        }
        return employee;
    }

    @Override
    public Employee getEmployeeById(long id)
    {
        return employeeRepository.findById(id).orElse(null);
    }
}
