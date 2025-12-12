package com.example.programacionReactivaProyect.Domain.Model.Gateway;

import com.example.programacionReactivaProyect.Domain.Model.Alert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AlertGateway {
    //aqui se detectara y se enviara real time notifications
    Mono<Alert> sendRealTimeNoti(Integer idSubscription);
    Flux<Alert> retrieveAlertHistoy(Integer idUsuario);
}



