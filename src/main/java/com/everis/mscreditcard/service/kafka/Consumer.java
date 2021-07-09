package com.everis.mscreditcard.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {
	
	@KafkaListener(topics="test_topic", groupId = "group_id")
	public void consumeMessage(String message) {
		log.info("Mensaje recibido del topic es: "+message);
	}

}
