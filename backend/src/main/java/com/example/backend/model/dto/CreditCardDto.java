package com.example.backend.model.dto;

import com.example.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreditCardDto {

    @NotNull
    private String transactionalNumber;

    @NotNull
    private UsernameDto usernameDto;

    @NotNull
    private String cvvCode;

    @NotNull
    private Long expirationMonth;

    @NotNull
    private Long expirationYear;

    public CreditCardDto(String transactionalNumber,
                         UsernameDto usernameDto,
                         String cvvCode,
                         Long expirationMonth,
                         Long expirationYear) {
        this.transactionalNumber = transactionalNumber;
        this.usernameDto = usernameDto;
        this.cvvCode = cvvCode;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }
}
