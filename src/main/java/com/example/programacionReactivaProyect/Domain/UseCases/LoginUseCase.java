package com.example.programacionReactivaProyect.Domain.UseCases;

import com.example.programacionReactivaProyect.Domain.DTO.LoginDto;
import com.example.programacionReactivaProyect.Domain.Exceptions.InvalidCredentialsException;
import com.example.programacionReactivaProyect.Domain.Exceptions.UserNotFoundException;
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

    public Mono<User>execute(LoginDto loginDto){
        LoginDto loginClean=validateUserLogin(loginDto);
        return userGateway.getByEmail(loginClean.getEmail())
                .switchIfEmpty(Mono.error(new UserNotFoundException("User not found with email"+loginClean.getEmail())))
                .flatMap(user -> passwordEncoderGateway.comparePassword(loginClean.getPassword(), user.getPassword())
                        .flatMap(matches->{
                            if(matches){
                                return Mono.just(user);
                            }else{
                                return Mono.error(new InvalidCredentialsException("Invalid password"));
                            }
                        }));
    }



    private LoginDto validateUserLogin(LoginDto loginDto){
        String email= loginDto.getEmail().trim();
        String password= loginDto.getPassword().trim();
        LoginDto loginClean=new LoginDto(email,password);
        return loginClean;
    }
}
