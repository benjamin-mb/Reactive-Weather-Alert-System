package com.example.programacionReactivaProyect.Domain.Model.Gateway;

import com.example.programacionReactivaProyect.Domain.DTO.WeatherAnswer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WeatherApiGateway {
    Mono<WeatherAnswer>currentWeather(String city);
    Flux<WeatherAnswer>streamWeatherUpdates(String city, Integer idSubciption);
    Flux<WeatherAnswer>stream10Cities(Integer idUser);

}
