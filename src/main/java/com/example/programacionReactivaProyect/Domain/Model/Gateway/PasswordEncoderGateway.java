package com.example.programacionReactivaProyect.Domain.Model.Gateway;

import reactor.core.publisher.Mono;

public interface PasswordEncoderGateway {
    public Mono<String> passwordEncode(String password);
    public Mono<Boolean> comparePassword(String passwordToCheck, String password);
}
