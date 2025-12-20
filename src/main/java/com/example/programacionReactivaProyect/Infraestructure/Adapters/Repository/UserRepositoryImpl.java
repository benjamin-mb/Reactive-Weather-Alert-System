package com.example.programacionReactivaProyect.Infraestructure.Adapters.Repository;

import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import reactor.core.publisher.Mono;

public class UserRepositoryImpl implements UserGateway {
    @Override
    public Mono<User> save(User user) {
        return null;
    }

    @Override
    public Mono<User> getByEmail(String email) {

    }
}
