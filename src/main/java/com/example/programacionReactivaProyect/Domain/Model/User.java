package com.example.programacionReactivaProyect.Domain.Model;

import jakarta.validation.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "user")
public class User {

    @Id
    Integer id;

    String name;

    @Email
    String email;

}
