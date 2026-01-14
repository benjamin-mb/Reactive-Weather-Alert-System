package com.example.programacionReactivaProyect.Domain.UseCases;

import com.example.programacionReactivaProyect.Domain.DTO.LoginDto;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.PasswordEncoderGateway;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import reactor.core.publisher.Mono;

public class LoginUseCase {

    private final UserGateway userGateway;
    private final PasswordEncoderGateway passwordEncoderGateway;

    public LoginUseCase(UserGateway userGateway, PasswordEncoderGateway passwordEncoderGateway) {
        this.userGateway = userGateway;
        this.passwordEncoderGateway = passwordEncoderGateway;
    }

    public Mono<User> validateUserLogin(LoginDto loginDto){
        String email= loginDto.getEmail().trim();
        String password= loginDto.getPassword().trim();


    }
}
