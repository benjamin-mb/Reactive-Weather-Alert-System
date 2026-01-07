package com.example.programacionReactivaProyect.Infraestructure.Adapters.Api.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class GeoCodingResponse {
    private String name;
    private String country;
    private BigDecimal lat;
    private BigDecimal lon;
    private String state;
}
