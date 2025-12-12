package com.example.programacionReactivaProyect.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherAnswer {
    private String city;
    private String country;
    private Severity severity;
    private AlertType alertType;
    private DecimalFormat temperature;
    private DecimalFormat feeling;
    private Integer humidity;
    private DecimalFormat windSpeed;
    private Integer pressure;
    private String description;
    private LocalDateTime timestamp;
}
