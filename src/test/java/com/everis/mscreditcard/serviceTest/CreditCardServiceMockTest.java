package com.everis.mscreditcard.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.everis.mscreditcard.repository.CreditCardRepository;
import com.everis.mscreditcard.service.CreditCardService;

@SpringBootTest
class CreditCardServiceMockTest {
	
	private static final String N_CREDIT_CARD = "6789-2323-5455-2888";
	
	@Mock
	private CreditCardRepository creditCardRepository;

	@InjectMocks
	private CreditCardService creditCardservice; 
	
	@BeforeEach
	void setMockOutput() {
		when(creditCardRepository.findByNumberCreditCard(N_CREDIT_CARD).thenReturn("Number Credit Card found"));
	}
	
    @DisplayName("Test Mock repository + service")
	@Test
	void testFindByNumberCreditCard() {
		assertEquals("Number Credit Card found", creditCardservice.findByNumberCreditCard(N_CREDIT_CARD));
	}

}
