package com.example.programacionReactivaProyect.Infraestructure.Adapters.Security;

import com.example.programacionReactivaProyect.Domain.Model.Gateway.PasswordEncoderGateway;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class PasswordEncoderImpl implements PasswordEncoderGateway {

    private PasswordEncoder passwordEncoder;

    @Override
    public Mono<String> passwordEncode(String password) {
        return Mono.fromCallable(()->passwordEncoder.encode(password))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
