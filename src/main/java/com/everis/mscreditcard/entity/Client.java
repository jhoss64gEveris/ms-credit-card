package com.everis.mscreditcard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String idClient;
    private String clientDescription;
    private String status;
    private String typePerson;
}
