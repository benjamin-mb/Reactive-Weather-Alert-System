package com.example.programacionReactivaProyect.Domain.UseCases;

import com.example.programacionReactivaProyect.Domain.DTO.CreateUserDto;
import com.example.programacionReactivaProyect.Domain.Exceptions.EmailOnUseException;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import reactor.core.publisher.Mono;

public class CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Mono<User>createUser(CreateUserDto createUserDto){
        validation(createUserDto);
        return userGateway.getByEmail(createUserDto.getEmail()).onErrorResume()
                .switchIfEmpty(Mono.error(()->new EmailOnUseException("Email Already Registered")));
    }

    private Mono<CreateUserDto> validation (CreateUserDto createUserDto){
        if (createUserDto.getName()==null || createUserDto.getName().isBlank()){
            Mono.error(()->new IllegalStateException("Name can't be blank"));
        }
        if (createUserDto.getPhone()==null || createUserDto.getPhone().isBlank()){
            Mono.error(()->new IllegalStateException("Phone can't be blank"));
        }
        if (createUserDto.getPassword()==null || createUserDto.getPassword().isBlank()){
            Mono.error(()->new IllegalStateException("Password can't be blank"));
        }
        if (createUserDto.getEmail()==null || createUserDto.getEmail().isBlank()){
            Mono.error(()->new IllegalStateException("Name can't be blank"));
        }
        return Mono.just(createUserDto);
    }
}
