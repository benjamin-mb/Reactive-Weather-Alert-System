package com.example.programacionReactivaProyect.Domain.Model.Gateway;

import com.example.programacionReactivaProyect.Domain.DTO.LocationDto;
import reactor.core.publisher.Mono;

public interface LocationApiGateway {
    Mono<LocationDto> cityDiscover(String city);
}
