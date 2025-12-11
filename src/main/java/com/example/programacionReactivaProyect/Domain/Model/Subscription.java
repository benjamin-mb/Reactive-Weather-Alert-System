package com.example.programacionReactivaProyect.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    private Integer id;
    private Integer idUser;
    private String city;
    private String country;
    private BigDecimal lat;
    private BigDecimal lon;
    private BigDecimal maxTemp;
    private BigDecimal minTemp;
    private BigDecimal maxWind;
    private boolean active;
    private LocalDateTime createdAt;

        public Subscription(Integer idUser, String city, String country, BigDecimal lat,
                        BigDecimal lon, BigDecimal maxTemp, BigDecimal minTemp,
                        BigDecimal maxWind, boolean active) {
        this.idUser = idUser;
        this.city = city;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.maxWind = maxWind;
        this.active = active;
        this.createdAt = LocalDateTime.now();
    }
}
