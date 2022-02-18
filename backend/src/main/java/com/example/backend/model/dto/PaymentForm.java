package com.example.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class PaymentForm {

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String city;

    @NotNull
    private String address;

    @NotNull
    private String cardNumber;

    @NotNull
    private String cvvCode;

    @NotNull
    private UsernameDto usernameDto;

    @NotNull
    private Long carPrice;

    @NotNull
    private Long carId;
}
