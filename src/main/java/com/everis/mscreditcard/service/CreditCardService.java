package com.everis.mscreditcard.service;

import com.everis.mscreditcard.entity.CreditCard;
import com.everis.mscreditcard.repository.CreditCardRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreditCardService {

    private final CreditCardRepository repository;
    
    public Mono<CreditCard> findByNumberCreditCard(String numberCreditCard){
        return repository.findByNumberCreditCard(numberCreditCard)
            .doOnNext(p -> log.info("Find Credit Card with number is "+ p.getNumberCreditCard()));

    }
    
    public Mono<CreditCard> createCreditCard(CreditCard creditCard){
    	return repository.save(creditCard)
    			.doOnNext(p-> log.info("Save credit card number "+p.getNumberCreditCard()));
    }
    
}
