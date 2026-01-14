package com.example.programacionReactivaProyect.Domain.UseCases;

import com.example.programacionReactivaProyect.Domain.Exceptions.SubscriptionNotFound;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.SubscriptionGateway;
import com.example.programacionReactivaProyect.Domain.Model.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class GetSubscriptionUseCase {

    private final SubscriptionGateway subscriptionGateway;

    public GetSubscriptionUseCase(SubscriptionGateway subscriptionGateway) {
        this.subscriptionGateway = subscriptionGateway;
    }

    public Mono<Subscription> getSubscriptionByCityAndIdUser(String city, Integer idUser){
        String cityClean=city.trim();
        return subscriptionGateway.getSubscriptionByIdUserAndCity(idUser,city)
                .switchIfEmpty(Mono.error(new SubscriptionNotFound("Subscription on "+city+"was not found")));
    }

    public Flux<Subscription> getAllSubscriptionById(Integer idUser){
        return subscriptionGateway.getSubscriptions(idUser);
    }

}
