package com.example.programacionReactivaProyect.Domain.UseCases;

import com.example.programacionReactivaProyect.Domain.Exceptions.UserNotFoundException;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import reactor.core.publisher.Mono;

public class GetUserUseCase {

    private final UserGateway userGateway;

    public GetUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Mono<User> getUserByEmail(String email){
        String emailClean=email.trim();
        return userGateway.getByEmail(emailClean)
                .switchIfEmpty(Mono.error(new UserNotFoundException("User not found by email"+email)));
    }

    public Mono<User> getById(Integer id){
        return userGateway.getById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException("User not found by id:"+id)));
    }

}
