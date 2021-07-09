package com.everis.mscreditcard.handler;

import com.everis.mscreditcard.entity.CreditCard;
import com.everis.mscreditcard.service.CreditCardService;
import com.everis.mscreditcard.service.kafka.Producer;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    private final Producer producer;
    
    public Mono<ServerResponse> findByNumberCreditCard (ServerRequest request){
    	producer.sendMessageString("Estamos buscando un card credit"); //prueba del kafka
        var mono = service
            .findByNumberCreditCard(String.valueOf(request.pathVariable("numberCreditCard")))
            .switchIfEmpty(Mono.error(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ServerResponse.ok()
                .body(BodyInserters.fromPublisher(mono, CreditCard.class));
    }
    
    public Mono<ServerResponse> createCreditCard (ServerRequest request){
    	final Mono<CreditCard> creditCard = request.bodyToMono(CreditCard.class);
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON)
    			.body(BodyInserters.fromPublisher(creditCard.flatMap(service::createCreditCard),CreditCard.class));
    }
}
