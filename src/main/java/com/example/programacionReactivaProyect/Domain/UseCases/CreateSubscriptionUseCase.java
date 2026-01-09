package com.example.programacionReactivaProyect.Domain.UseCases;

import com.example.programacionReactivaProyect.Domain.Exceptions.LocationNotAvailable;
import com.example.programacionReactivaProyect.Domain.Exceptions.UserNotFoundException;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.LocationApiGateway;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.SubscriptionGateway;
import com.example.programacionReactivaProyect.Domain.Model.Gateway.UserGateway;
import com.example.programacionReactivaProyect.Domain.Model.Subscription;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public class CreateSubscriptionUseCase {

    private final SubscriptionGateway subscriptionGateway;
    private final UserGateway userGateway;
    private final LocationApiGateway locationGateway;
    public CreateSubscriptionUseCase(SubscriptionGateway subscriptionGateway, UserGateway userGateway, LocationApiGateway locationGateway) {
        this.subscriptionGateway = subscriptionGateway;
        this.userGateway = userGateway;
        this.locationGateway = locationGateway;
    }

    private Mono<Subscription>execute(Subscription subscription){
        return validation(subscription)
                .flatMap(s->gettingLocationValidated(s))
                .flatMap()
    }

    private
    private Mono<Subscription> gettingLocationValidated(Subscription subscription){
        return locationGateway.cityDiscover(subscription.getCity())
                .switchIfEmpty(Mono.error(new LocationNotAvailable("The location "+subscription.getCity()+" was not found")))
                .flatMap(locationDto -> {
                    subscription.setCity(locationDto.getCity());
                    subscription.setCountry(locationDto.getCountry());
                    subscription.setLat(locationDto.getLat());
                    subscription.setLon(locationDto.getLon());
                    return Mono.just(subscription);
                });
    }
    private Mono<Subscription> validation(Subscription subscription) {
        return Mono.just(subscription)
                .filter(s->s.getCity()!= null && !s.getCity().isBlank())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("City is a must")))
                .filter(s->s.getIdUser()!=null)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("id user can't be blank")))
                .flatMap(s->(userGateway.getById(s.getIdUser())
                        .map(user->s)
                        .switchIfEmpty(Mono.error(new UserNotFoundException("User not found: " + s.getIdUser())))))
                .filter(s -> s.getMaxTemp() != null && s.getMinTemp() != null)
                .switchIfEmpty(Mono.error(
                        new IllegalArgumentException("Temperature thresholds are required")
                ))
                .filter(s -> s.getMaxTemp().compareTo(s.getMinTemp()) > 0)
                .switchIfEmpty(Mono.error(
                        new IllegalArgumentException("Max temperature must be greater than min temperature")
                ))
                .filter(s -> s.getMaxWind() != null && s.getMaxWind().compareTo(BigDecimal.ZERO) > 0)
                .switchIfEmpty(Mono.error(
                        new IllegalArgumentException("Max wind speed must be greater than 0")
                ));
    }
}
