package com.example.backend.web.rest;

import com.example.backend.model.CreditCard;
import com.example.backend.model.dto.*;
import com.example.backend.model.exceptions.NotEnoughMoneyOnTheCreditCardException;
import com.example.backend.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:8080")
public class PaymentResource {

    public final CreditCardService creditCardService;

    public PaymentResource(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public List<CreditCard> findAllCreditCardsByUser(@RequestBody UsernameDto usernameDto) {
        return creditCardService.listAllCreditCardByUser(usernameDto);
    }

    @PostMapping("/get-credit-card-by-number")
    public Optional<CreditCard> findCreditCardByCardNumber(@RequestBody CreditCardNumberDto creditCardNumberDto) {
        return creditCardService.findCreditCardByCardNumber(creditCardNumberDto);
    }

    @PostMapping("/buy-car")
    public Optional<CreditCard> buyCarWithCreditCard(@RequestBody PaymentForm paymentForm)
            throws NotEnoughMoneyOnTheCreditCardException {
        return creditCardService.buyCarByCardNumber(paymentForm);
    }

    @PostMapping("/add-credit-card")
    public Optional<CreditCard> addCreditCard(@RequestBody CreditCardDto creditCardDto) {
        return creditCardService.addCreditCardByUser(creditCardDto);
    }

    @PostMapping("/delete-credit-card")
    public void deleteCreditCard(@RequestBody CreditCardNumberDto creditCardNumberDto) {
        creditCardService.deleteCreditCard(creditCardNumberDto);
    }

}
