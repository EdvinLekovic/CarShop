package com.example.backend.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class CreditCard {

    @Id
    private String transactionalNumber;

    @ManyToOne
    private User user;

    private Long money;

    private String cvvCode;

    private Long expirationMonth;

    private Long expirationYear;

    public CreditCard(String transactionalNumber,
                      User user,
                      Long money,
                      String cvvCode,
                      Long expirationMonth,
                      Long expirationYear) {
        this.transactionalNumber = transactionalNumber;
        this.user = user;
        this.money = money;
        this.cvvCode = cvvCode;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public CreditCard() {}
}
