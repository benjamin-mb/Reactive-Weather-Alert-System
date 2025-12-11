package com.example.programacionReactivaProyect.Domain.DTO;

import com.example.programacionReactivaProyect.Domain.Model.AlertType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherAnswer {
    private String city;
    private String country;
    private AlertType alertType;
    private DecimalFormat temperature;
    private DecimalFormat feeling;
    private Integer humidity;
    private DecimalFormat windSpeed;
    private Integer pressure;
    private String description;
}
