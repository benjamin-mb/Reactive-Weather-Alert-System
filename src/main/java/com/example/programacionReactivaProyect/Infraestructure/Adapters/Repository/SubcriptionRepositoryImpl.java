package com.example.programacionReactivaProyect.Infraestructure.Adapters.Repository;

import com.example.programacionReactivaProyect.Domain.Model.Gateway.SubscriptionGateway;
import com.example.programacionReactivaProyect.Domain.Model.Subscription;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Entity.SubscriptionEntity;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Mapper.SubscriptionMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Component
public class SubcriptionRepositoryImpl implements SubscriptionGateway {

    private final SubscriptionRD2BCRepository repository;
    private final SubscriptionMapper mapper;

    public SubcriptionRepositoryImpl(SubscriptionRD2BCRepository repository, SubscriptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<Subscription> save(Subscription subscription) {
        SubscriptionEntity entity = mapper.toEntity(subscription);
        return repository.save(entity)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Subscription> getSubscriptions(Integer userId) {
        return repository.getAllSubscriptionByUserId(userId)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Subscription> updateAlertThresholds(Integer id, BigDecimal maxTemp, BigDecimal minTemp, BigDecimal maxWind) {
        return null;
    }

    @Override
    public Mono<Subscription> getSubscriptionByIdUserAndCity(Integer idUser, String city) {
       return repository.getSubscriptionByUserIdAndCity(idUser,city)
               .map(mapper::toDomain);
    }
}
