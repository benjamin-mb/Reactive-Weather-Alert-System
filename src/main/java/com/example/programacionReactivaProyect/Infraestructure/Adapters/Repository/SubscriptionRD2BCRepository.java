package com.example.programacionReactivaProyect.Infraestructure.Adapters.Repository;

import com.example.programacionReactivaProyect.Infraestructure.Adapters.Entity.SubscriptionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubscriptionRD2BCRepository extends ReactiveCrudRepository<SubscriptionEntity,Integer> {
    Mono<SubscriptionEntity>getSubscriptionByUserIdAndCity(Integer UserId,String city);
    Flux<SubscriptionEntity>getAllSubscriptionByUserId(Integer UserId);
}
