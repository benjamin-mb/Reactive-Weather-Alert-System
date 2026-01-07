package com.example.programacionReactivaProyect.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private String city;
    private String country;
    private BigDecimal lat;
    private BigDecimal lon;
}
