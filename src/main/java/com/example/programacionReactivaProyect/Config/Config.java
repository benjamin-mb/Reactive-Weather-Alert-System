package com.example.programacionReactivaProyect.Config;

import com.example.programacionReactivaProyect.Domain.Model.Gateway.*;

import com.example.programacionReactivaProyect.Domain.UseCases.CreateSubscriptionUseCase;
import com.example.programacionReactivaProyect.Domain.UseCases.CreateUserUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway userGateway, PasswordEncoderGateway passwordEncoderGateway){
        return new CreateUserUseCase(userGateway,passwordEncoderGateway);
    }

    @Bean
    public CreateSubscriptionUseCase createSubscriptionUseCase(SubscriptionGateway subscriptionGateway, UserGateway userGateway, LocationApiGateway locationGateway){
        return new CreateSubscriptionUseCase(subscriptionGateway,userGateway,locationGateway);
    }

}
