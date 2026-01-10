package com.example.programacionReactivaProyect.Config;

import com.example.programacionReactivaProyect.Domain.Model.Gateway.AlertGateway;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.PasswordEncoderGateway;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;

import com.example.programacionReactivaProyect.Domain.UseCases.CreateUserUseCase;
import com.example.programacionReactivaProyect.Domain.UseCases.GetUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway, PasswordEncoderGateway passwordEncoderGateway){
        return new CreateUserUseCase(userGateway,passwordEncoderGateway);
    }

}
