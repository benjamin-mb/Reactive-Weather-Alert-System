package com.example.programacionReactivaProyect.Infraestructure.Adapters.Api;

import com.example.programacionReactivaProyect.Domain.DTO.LocationDto;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.LocationApiGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class OpenWeatherApi implements LocationApiGateway {

    private final WebClient webClient;
    private final String apiKey;

    public OpenWeatherApi(WebClient webClient, @Value("$(openweathermap.api.key)") String apiKey) {
        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    @Override
    public Mono<LocationDto> cityDiscover(String city) {
        return null;
    }
}
