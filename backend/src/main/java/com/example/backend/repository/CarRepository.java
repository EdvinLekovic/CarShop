package com.example.backend.repository;

import com.example.backend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT * " +
            "FROM Car c " +
            "WHERE c.purchased = false",
            nativeQuery = true)
    List<Car> listAllUnPurchasedCars();
}
