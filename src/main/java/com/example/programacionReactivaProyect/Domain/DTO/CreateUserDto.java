package com.example.programacionReactivaProyect.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserDto {

    private String name;
    private String email;
    private String phone;
    private String password;
    private boolean emailNotifications;
    private boolean smsNotifications;
    private boolean pushNotifications;
    private LocalDateTime createdAt;

    public CreateUserDto(String name, String email, String phone, String password,
                         boolean emailNotifications, boolean smsNotifications,
                         boolean pushNotifications) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.emailNotifications = emailNotifications;
        this.smsNotifications = smsNotifications;
        this.pushNotifications = pushNotifications;
        this.createdAt=LocalDateTime.now();
    }
}
