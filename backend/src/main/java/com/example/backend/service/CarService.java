package com.example.backend.service;

import com.example.backend.model.Car;
import com.example.backend.model.dto.AddCarDto;
import com.example.backend.model.dto.EditCarDto;
import com.example.backend.model.dto.UsernameDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> listAllUnPurchasedCars();

    Optional<Car> addCar(AddCarDto carDto) throws JsonProcessingException;

    void deleteCar(Long id);

    Optional<Car> editCar(EditCarDto editCarDto);

    Optional<Car> findCarById(Long id);

    List<Car> findAllCarsByUser(UsernameDto usernameDto);

    Long carsQuantityPurchased(UsernameDto usernameDto,Long id);

    public byte[] getImage(Long id, Integer index);
}
