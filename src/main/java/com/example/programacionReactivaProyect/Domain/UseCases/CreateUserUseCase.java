package com.example.programacionReactivaProyect.Domain.UseCases;

import com.example.programacionReactivaProyect.Domain.DTO.CreateUserDto;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.PasswordEncoderGateway;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class CreateUserUseCase {

    private final UserGateway userGateway;
    private final PasswordEncoderGateway passwordEncoderGateway;

    public CreateUserUseCase(UserGateway userGateway, PasswordEncoderGateway passwordEncoderGateway) {
        this.userGateway = userGateway;
        this.passwordEncoderGateway = passwordEncoderGateway;
    }

    public Mono<User>createUser(CreateUserDto createUserDto){
       return validation(createUserDto)
               .flatMap(validUser->
                       passwordEncoderGateway.passwordEncode(validUser.getPassword())
               .map(encodedPassword->{
                   validUser.setPassword(encodedPassword);
                   return validUser;
               })
               ).flatMap(userGateway::save);

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
        boolean passwordCheck=checkPassword(createUserDto.getPassword());
        if (passwordCheck==false){
            return Mono.error(()->new IllegalArgumentException("Password does not match the requirements"));
        }
        if (createUserDto.getEmail()==null || createUserDto.getEmail().isBlank()){
            return Mono.error(()->new IllegalStateException("Name can't be blank"));
        }
        String password=createUserDto.getPassword().trim();
        User user=new User(createUserDto.getName(),createUserDto.getEmail(),
                createUserDto.getPhone(),password,
                createUserDto.isEmailNotifications(), createUserDto.isSmsNotifications(),
                createUserDto.isPushNotifications()
                );

        return Mono.just(user);
    }

    private boolean checkPassword(String password){
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
