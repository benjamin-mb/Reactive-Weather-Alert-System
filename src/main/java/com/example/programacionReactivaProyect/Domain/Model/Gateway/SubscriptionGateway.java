package com.example.programacionReactivaProyect.Domain.Model.Gateway;

import com.example.programacionReactivaProyect.Domain.Model.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

public interface SubscriptionGateway {

    Mono<Subscription>suscribeToCity(Subscription suscription);
    Flux<Subscription>getSubscriptions(String email);
    Mono<Subscription>updateAlertThresholds(Integer id,BigDecimal maxTemp,
     BigDecimal minTemp,BigDecimal maxWind);
    Mono<Void>deleteSubscription(Integer id);
}
