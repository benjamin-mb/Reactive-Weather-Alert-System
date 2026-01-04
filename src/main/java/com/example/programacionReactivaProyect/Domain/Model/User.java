package com.example.programacionReactivaProyect.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private boolean emailNotifications;
    private boolean smsNotifications;
    private boolean pushNotifications;
    private LocalDateTime createdAt;

    public User(String name, String email,
                String phone, String password,
                boolean emailNotifications,
                boolean smsNotifications,
                boolean pushNotifications) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.emailNotifications = emailNotifications;
        this.smsNotifications = smsNotifications;
        this.pushNotifications = pushNotifications;
        this.createdAt = LocalDateTime.now();
    }

    public User(String name, String email,
                String phone, String password
               ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.emailNotifications = false;
        this.smsNotifications = false;
        this.pushNotifications = false;
        this.createdAt = LocalDateTime.now();
    }

    public User(String name, String email, String phone, boolean emailNotifications, boolean smsNotifications, boolean pushNotifications) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.emailNotifications = emailNotifications;
        this.smsNotifications = smsNotifications;
        this.pushNotifications = pushNotifications;
        this.createdAt = createdAt;
    }

    public User(String name, String email, String phone, String password, Object o, boolean emailNotifications, boolean smsNotifications, boolean pushNotifications) {
    }
}

