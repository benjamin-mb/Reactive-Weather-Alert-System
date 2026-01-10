package com.example.programacionReactivaProyect.Infraestructure.Adapters.Repository;

import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.User;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Mapper.UserMapper;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserGateway {

     private  final UserMapper mapper;
     private final UserRD2BCRepository userRD2BCRepository;

    public UserRepositoryImpl(UserMapper mapper, UserRD2BCRepository userRD2BCRepository) {
        this.mapper = mapper;
        this.userRD2BCRepository = userRD2BCRepository;
    }

    @Override
    public Mono<User> save(User user) {
       return mapper.mapToEntity(user)
               .flatMap(userRD2BCRepository::save)
               .flatMap(mapper::mapToDomain);
    }

    @Override
    public Mono<User> getByEmail(String email) {
        return userRD2BCRepository.findByEmail(email)
                .flatMap(mapper::mapToDomain);
    }

    @Override
    public Mono<User> getById(Integer id) {
        return userRD2BCRepository.findById(id)
                .flatMap(mapper::mapToDomain);
    }
}
