package com.example.test.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name = "employee")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required!!!")
    private String name;

    @NotBlank(message = "Position is required!!!")
    private String position;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required!!!")
    private String email;

    @Positive(message = "Salary must be greater than 0")
    private int salary;

}
