package com.example.programacionReactivaProyect.Infraestructure.Adapters.Mapper;

import com.example.programacionReactivaProyect.Domain.Model.User;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Entity.UserEntity;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class UserMapper {

    public Mono<User> mapToDomain(UserEntity userEntity){

        User user=new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPhone(),
                userEntity.getPassword(),
                userEntity.isEmailNotifications(),
                userEntity.isSmsNotifications(),
                userEntity.isPushNotifications(),
                LocalDateTime.now()
        );
        return Mono.just(user);
    }

    public Mono<UserEntity> mapToEntity(User user){

        UserEntity userEntity=new UserEntity(
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                user.isEmailNotifications(),
                user.isSmsNotifications(),
                user.isPushNotifications()
        );
        return Mono.just(userEntity);
    }
}
