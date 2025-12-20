package com.example.programacionReactivaProyect.Infraestructure.Adapters.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private boolean emailNotifications;
    private boolean smsNotifications;
    private boolean pushNotifications;
    private LocalDateTime createdAt;

    public UserEntity(String name, String email,
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

}
