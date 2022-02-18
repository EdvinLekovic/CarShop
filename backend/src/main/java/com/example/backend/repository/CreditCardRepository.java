package com.example.backend.repository;

import com.example.backend.model.CreditCard;
import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard,String> {
    List<CreditCard> findAllByUser(User user);
}
