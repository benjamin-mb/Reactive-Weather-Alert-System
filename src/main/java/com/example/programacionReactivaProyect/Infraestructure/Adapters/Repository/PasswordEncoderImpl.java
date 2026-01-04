package com.example.programacionReactivaProyect.Infraestructure.Adapters.Repository;

import com.example.programacionReactivaProyect.Domain.Model.Gateway.PasswordEncoderGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


public class PasswordEncoderImpl implements PasswordEncoderGateway {

    private PasswordEncoder passwordEncoder;

    @Override
    public Mono<String> passwordEncode(String password) {
        return Mono.fromCallable(()->passwordEncoder.encode(password))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
