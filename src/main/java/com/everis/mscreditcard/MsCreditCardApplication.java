package com.everis.mscreditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class MsCreditCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCreditCardApplication.class, args);
	}

}
