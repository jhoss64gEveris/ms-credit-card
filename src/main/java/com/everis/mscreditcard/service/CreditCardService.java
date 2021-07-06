package com.everis.mscreditcard.service;

import com.everis.mscreditcard.entity.CreditCard;
import com.everis.mscreditcard.repository.creditCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreditCardService {

    @Autowired
    creditCardRepository repository;

    public Mono<CreditCard> findByNumberCreditCard(String numberCreditCard){
        return repository.findByNumberCreditCard(numberCreditCard)
            .doOnNext(p -> log.info("Find Credit Card with number is "+ p.getNumberCreditCard()));

    }
    
}
