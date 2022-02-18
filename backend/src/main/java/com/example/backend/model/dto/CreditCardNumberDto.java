package com.example.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreditCardNumberDto {

    @NotNull
    private String cardNumber;

    CreditCardNumberDto(){}

    public CreditCardNumberDto(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
