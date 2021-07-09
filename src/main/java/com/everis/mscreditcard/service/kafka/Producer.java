package com.everis.mscreditcard.service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class Producer {
	
	private static final String TOPIC = "test_topic";
	private final KafkaTemplate<String,String> kafkaTemplate;
	
	public void sendMessageString(String message) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				log.info("Mensaje ha sido enviado ",message);				
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("NO SE HA ENVIADO EL MENSAJE");
			}
		});
		
	}
	
	public NewTopic createTopic() {
		return new NewTopic(TOPIC,3,(short) 1);
	}
}
