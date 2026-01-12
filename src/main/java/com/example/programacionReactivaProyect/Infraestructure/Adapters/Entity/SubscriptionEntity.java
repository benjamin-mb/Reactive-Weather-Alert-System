package com.example.programacionReactivaProyect.Infraestructure.Adapters.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("subscription")
public class SubscriptionEntity {

    @Id
    private Integer id;

    @Column("user_id")
    private Integer userId;

    @Column("city")
    private String city;

    @Column("country")
    private String country;

    @Column("lat")
    private BigDecimal lat;

    @Column("lon")
    private BigDecimal lon;

    @Column("max_temp")
    private BigDecimal maxTemp;

    @Column("min_temp")
    private BigDecimal minTemp;

    @Column("max_wind_speed")
    private BigDecimal maxWindSpeed;

    @Column("active")
    private Boolean active;

    @Column("created_at")
    private LocalDateTime createdAt;



    public SubscriptionEntity(Integer id, Integer userId, String city,  String country,BigDecimal lat, BigDecimal lon, BigDecimal maxTemp, BigDecimal minTemp, BigDecimal maxWindSpeed, Boolean active) {
        this.id = id;
        this.userId = userId;
        this.city = city;
        this.lat = lat;
        this.country = country;
        this.lon = lon;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.maxWindSpeed = maxWindSpeed;
        this.active = active;
        this.createdAt = LocalDateTime.now();

    }
}
