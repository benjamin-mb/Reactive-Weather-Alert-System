package com.example.programacionReactivaProyect.Infraestructure.Adapters.Mapper;

import com.example.programacionReactivaProyect.Domain.Model.Subscription;
import com.example.programacionReactivaProyect.Domain.Model.User;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Entity.SubscriptionEntity;
import com.example.programacionReactivaProyect.Infraestructure.Adapters.Entity.UserEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class SubscriptionMapper {

    public Subscription toDomain(SubscriptionEntity s){
        Subscription subscription=new Subscription(
                s.getUserId(),
                s.getCity(),
                s.getCountry(),
                s.getLat(),
                s.getLon(),
                s.getMaxTemp(),
                s.getMinTemp(),
                s.getMaxWindSpeed(),
                s.getActive()
        );
        return subscription;
    }

    public SubscriptionEntity toEntity(Subscription s){
        SubscriptionEntity subscriptionEntity=new SubscriptionEntity(
                s.getId(),
                s.getIdUser(),
                s.getCity(),
                s.getCountry(),
                s.getLat(),
                s.getLon(),
                s.getMaxTemp(),
                s.getMinTemp(),
                s.getMaxWind(),
                s.getActive()
        );
        return subscriptionEntity;
    }
}
