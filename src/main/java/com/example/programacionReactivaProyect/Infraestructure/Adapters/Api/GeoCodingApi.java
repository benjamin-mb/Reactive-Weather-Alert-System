package com.example.programacionReactivaProyect.Infraestructure.Adapters.Api;

import com.example.programacionReactivaProyect.Domain.DTO.LocationDto;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.LocationApiGateway;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Api.Dto.GeoCodingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GeoCodingApi implements LocationApiGateway {

    private final WebClient webClient;
    private final String apiKey;
    int limit=1;


    public GeoCodingApi(WebClient webClient, @Value("${openweathermap.api.key}") String apiKey) {
        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    @Override
    public Mono<LocationDto> cityDiscover(String city) {
        return this.webClient.get()
                .uri("/geo/1.0/direct?q={city}&limit={limit}&appid={apiKey}", city, limit, apiKey)
                .retrieve()
                .bodyToFlux(GeoCodingResponse.class)
                .next()
                .map(this::mapper);
    }

    private LocationDto mapper(GeoCodingResponse dto){
        return new LocationDto(
                dto.getName(),
                dto.getCountry(),
                dto.getLat(),
                dto.getLon()
        );
    }
}
