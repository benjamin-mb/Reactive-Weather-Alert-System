package com.example.programacionReactivaProyect.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    private Integer id;
    private Integer idUser;
    private Integer idSubscription;
    private String city;
    private AlertType alertType;
    private BigDecimal temperature;
    private BigDecimal feeling;
    private Integer humidity;
    private BigDecimal windSpeed;
    private Integer pressure;
    private String description;
    private String message;
    private boolean read;
    private boolean notified;
    private LocalDateTime createdAt;

    public Alert(Integer idUser, Integer idSubscription, String city, AlertType alertType,
                 Integer humidity, BigDecimal temperature, BigDecimal feeling,
                 BigDecimal windSpeed, String message, String description,
                 Integer pressure, boolean read, boolean notified, LocalDateTime createdAt) {
        this.idUser = idUser;
        this.idSubscription = idSubscription;
        this.city = city;
        this.alertType = alertType;
        this.humidity = humidity;
        this.temperature = temperature;
        this.feeling = feeling;
        this.windSpeed = windSpeed;
        this.message = message;
        this.description = description;
        this.pressure = pressure;
        this.read = read;
        this.notified = notified;
        this.createdAt = createdAt;
    }
}
