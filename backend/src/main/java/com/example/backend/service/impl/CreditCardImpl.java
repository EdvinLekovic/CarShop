package com.example.backend.service.impl;

import com.example.backend.model.Car;
import com.example.backend.model.CreditCard;
import com.example.backend.model.User;
import com.example.backend.model.dto.*;
import com.example.backend.model.exceptions.NotEnoughMoneyOnTheCreditCardException;
import com.example.backend.repository.CarRepository;
import com.example.backend.repository.CreditCardRepository;
import com.example.backend.service.CarService;
import com.example.backend.service.CreditCardService;
import com.example.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CreditCardImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final UserService userService;
    private final CarRepository carRepository;

    public CreditCardImpl(CreditCardRepository creditCardRepository,
                          UserService userService,
                          CarRepository carRepository) {
        this.creditCardRepository = creditCardRepository;
        this.userService = userService;
        this.carRepository = carRepository;
    }

    @Override
    public List<CreditCard> listAllCreditCardByUser(UsernameDto usernameDto) {
        User user = userService.findUserByUsername(usernameDto.getUsername()).orElseThrow();
        return this.creditCardRepository.findAllByUser(user);
    }

    @Override
    public Optional<CreditCard> findCreditCardByCardNumber(CreditCardNumberDto cardNumberDto) {
        return creditCardRepository.findById(cardNumberDto.getCardNumber());
    }

    @Override
    public Optional<CreditCard> buyCarByCardNumber(PaymentForm paymentForm)
            throws NotEnoughMoneyOnTheCreditCardException {
        CreditCard creditCard = creditCardRepository.findById(paymentForm.getCardNumber()).orElseThrow();
        LocalDateTime now = LocalDateTime.now();
        System.out.println(creditCard.getExpirationYear() > now.getYear());
        System.out.println(creditCard.getExpirationMonth() >= now.getMonth().getValue());
        System.out.println(creditCard.getCvvCode().equals(paymentForm.getCvvCode()));
        System.out.println(creditCard.getMoney() >= paymentForm.getCarPrice());
        if ((creditCard.getExpirationYear() > now.getYear() || creditCard.getExpirationMonth() >= now.getMonth().getValue()) &&
                creditCard.getCvvCode().equals(paymentForm.getCvvCode()) &&
                creditCard.getMoney() >= paymentForm.getCarPrice()) {
            creditCard.setMoney(creditCard.getMoney() - paymentForm.getCarPrice());
            Car car = carRepository.findById(paymentForm.getCarId()).orElseThrow();
            User user = userService.findUserByUsername(paymentForm.getUsernameDto().getUsername()).orElseThrow();
            car.getUsers().add(user);
            car.setQuantity(car.getQuantity() - 1);
            carRepository.save(car);
            return Optional.of(creditCardRepository.save(creditCard));
        } else {
            throw new NotEnoughMoneyOnTheCreditCardException();
        }
    }

    @Override
    public Optional<CreditCard> addCreditCardByUser(CreditCardDto creditCardDto) {

        User user = userService.findUserByUsername(creditCardDto.getUsernameDto().getUsername()).orElseThrow();
        double max = 1000000;
        double min = 500000;
        Long random_money = (long) Math.floor(Math.random() * (max - min + 1) + min);
        CreditCard creditCard = new CreditCard(creditCardDto.getTransactionalNumber(),
                user,
                random_money,
                creditCardDto.getCvvCode(),
                creditCardDto.getExpirationMonth(),
                creditCardDto.getExpirationYear());
        return Optional.of(creditCardRepository.save(creditCard));
    }

    @Override
    public void deleteCreditCard(CreditCardNumberDto creditCardNumberDto) {
        creditCardRepository.deleteById(creditCardNumberDto.getCardNumber());
    }

}
