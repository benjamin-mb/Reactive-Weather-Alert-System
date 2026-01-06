package com.example.programacionReactivaProyect.Infraestructure.Adapters.Repository;

import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Entity.UserEntity;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Mapper.UserMapper;
import reactor.core.publisher.Mono;

public class UserRepositoryImpl implements UserGateway {

     private  final UserMapper mapper;
     private final UserRepository userRepository;

    public UserRepositoryImpl(UserMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> save(User user) {
       return mapper.mapToEntity(user)
               .flatMap(userRepository::save)
               .flatMap(mapper::mapToDomain);
    }

    @Override
    public Mono<User> getByEmail(String email) {
        return userRepository.findByEmail(email)
                .flatMap(mapper::mapToDomain);
    }

    @Override
    public Mono<User> getById(Integer id) {
        return userRepository.findById(id)
                .flatMap(mapper::mapToDomain);
    }
}
