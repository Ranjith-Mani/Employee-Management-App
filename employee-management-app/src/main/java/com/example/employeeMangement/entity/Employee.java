// PACKAGE
package com.example.employeeMangement.entity;

// IMPORTS
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ANNOTATIONS
// LOMBOK ANNOTATIONS to avoid adding Constructor, Getter and Setter in Entity
// and also used for CODE READABILITY
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity //An ANNOTATION which is used to create a table
@Table(name="employee_data") //An ANNOTATION which is used to give name to a table

public class Employee
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(length = 50, nullable = false)
        private String firstName;

        @Column(length = 50, nullable = false)
        private String lastName;

        @Column(unique = true)
        private String email;
}
