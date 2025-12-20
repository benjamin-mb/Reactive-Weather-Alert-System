package com.example.programacionReactivaProyect.Domain.UseCases;

import com.example.programacionReactivaProyect.Domain.DTO.CreateUserDto;
import com.example.programacionReactivaProyect.Domain.Exceptions.EmailOnUseException;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Mono<User>createUser(CreateUserDto createUserDto){
       return validation(createUserDto)
               .flatMap(userToSave -> userGateway.getByEmail(userToSave.getEmail())
               .flatMap(userExist->
                       Mono.<User>error(new IllegalArgumentException("Email already registered"))
                               .switchIfEmpty(Mono.defer(()->userGateway.save(userToSave)))
               ));

    }

    private Mono<User> validation (CreateUserDto createUserDto){
        if (createUserDto.getName()==null || createUserDto.getName().isBlank()){
           return Mono.error(()->new IllegalStateException("Name can't be blank"));
        }
        if (createUserDto.getPhone()==null || createUserDto.getPhone().isBlank()){
           return Mono.error(()->new IllegalStateException("Phone can't be blank"));
        }
        if (createUserDto.getPassword()==null || createUserDto.getPassword().isBlank()){
           return Mono.error(()->new IllegalStateException("Password can't be blank"));
        }
        if (createUserDto.getEmail()==null || createUserDto.getEmail().isBlank()){
            return Mono.error(()->new IllegalStateException("Name can't be blank"));
        }

        User user=new User(createUserDto.getName(),createUserDto.getEmail(),
                createUserDto.getPhone(),createUserDto.getPassword(),
                createUserDto.isEmailNotifications(), createUserDto.isSmsNotifications(),
                createUserDto.isPushNotifications());

        return Mono.just(user);
    }

    private Boolean checkPassword(String password){
        if (password.length()<8){
            return false;
        }
        boolean hasUpper=password.chars().anyMatch(Character::isUpperCase);
        boolean hasSpecialCharacter=password.chars().anyMatch(c->!Character.isLetterOrDigit(c));
        if (!hasUpper || !hasSpecialCharacter){
            return false;
        }
        else {
            return true;
        }
    }

}
