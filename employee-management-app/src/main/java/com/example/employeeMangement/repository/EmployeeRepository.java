// PACKAGE
package com.example.employeeMangement.repository;

// IMPORTS
import com.example.employeeMangement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ANNOTATION
@Repository // An ANNOTATION which marks a class as a DAO(Data Access Object) for data access in Spring.

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}