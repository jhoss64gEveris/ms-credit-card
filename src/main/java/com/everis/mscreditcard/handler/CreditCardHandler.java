package com.everis.mscreditcard.handler;

import com.everis.mscreditcard.entity.CreditCard;
import com.everis.mscreditcard.service.CreditCardService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.var;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;

@RequiredArgsConstructor
@Component
public class CreditCardHandler {

    private final CreditCardService service;
    
    public Mono<ServerResponse> findByNumberCreditCard (ServerRequest request){
        var mono = service
            .findByNumberCreditCard(String.valueOf(request.pathVariable("numberCreditCard")))
            .switchIfEmpty(Mono.error(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ServerResponse.ok()
                .body(BodyInserters.fromPublisher(mono, CreditCard.class));
    }
}
