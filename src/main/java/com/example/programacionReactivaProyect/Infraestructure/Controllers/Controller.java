package com.example.programacionReactivaProyect.Infraestructure.Controllers;

import com.example.programacionReactivaProyect.Domain.DTO.LocationDto;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Api.GeoCodingApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive/v1")
public class Controller {

    private final GeoCodingApi geoCodingApi;

    public Controller(GeoCodingApi geoCodingApi) {
        this.geoCodingApi = geoCodingApi;
    }

    @GetMapping("/{city}")
    public Mono<LocationDto>gettingLocation(@PathVariable String city){
        return geoCodingApi.cityDiscover(city);
    }
}
