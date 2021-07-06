package com.everis.mscreditcard.entity;

import lombok.Data;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "creditCard")
public class CreditCard {
    private String idCreditCard;
    private String numberCreditCard;
    private Client owner;
    private String nameCreditCard;
    private Date dateValid;
    private String codeCVV;
}
