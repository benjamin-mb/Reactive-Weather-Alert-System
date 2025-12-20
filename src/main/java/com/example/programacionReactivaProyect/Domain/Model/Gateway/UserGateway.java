package com.example.programacionReactivaProyect.Domain.Model.Gateway;

import com.example.programacionReactivaProyect.Domain.Model.User;
import org.springframework.boot.webflux.autoconfigure.WebFluxProperties;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<User>save(User user);
    Mono<User>getByEmail(String email);

}
