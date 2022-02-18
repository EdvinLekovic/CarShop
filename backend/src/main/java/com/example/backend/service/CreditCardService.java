package com.example.backend.service;

import com.example.backend.model.CreditCard;
import com.example.backend.model.dto.*;
import com.example.backend.model.exceptions.NotEnoughMoneyOnTheCreditCardException;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {
    List<CreditCard> listAllCreditCardByUser(UsernameDto usernameDto);

    Optional<CreditCard> findCreditCardByCardNumber(CreditCardNumberDto creditCardNumberDto);

    Optional<CreditCard> buyCarByCardNumber(PaymentForm paymentForm)
            throws NotEnoughMoneyOnTheCreditCardException;

    Optional<CreditCard> addCreditCardByUser(CreditCardDto creditCardDto);
    void deleteCreditCard(CreditCardNumberDto creditCardNumberDto);
}
