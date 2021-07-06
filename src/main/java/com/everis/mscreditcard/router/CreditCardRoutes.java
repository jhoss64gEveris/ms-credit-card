package com.everis.mscreditcard.router;

import com.everis.mscreditcard.handler.CreditCardHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CreditCardRoutes {
    
    @Bean
    public RouterFunction<ServerResponse> routes(CreditCardHandler handler){
        return RouterFunctions.route().path(
        "/creditCard", builder -> builder
            .GET("/{numberCreditCard}", handler::findByNumberCreditCard)
    ).build();
    }
}
