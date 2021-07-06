package com.everis.mscreditcard.repository;

import com.everis.mscreditcard.entity.CreditCard;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface creditCardRepository extends ReactiveMongoRepository<CreditCard,String>{
    public Mono<CreditCard> findByNumberCreditCard(String numberCreditCard);
}
