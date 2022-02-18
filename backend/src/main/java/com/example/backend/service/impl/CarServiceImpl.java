package com.example.backend.service.impl;

import com.example.backend.model.Brand;
import com.example.backend.model.Car;
import com.example.backend.model.Image;
import com.example.backend.model.Model;
import com.example.backend.model.dto.AddCarDto;
import com.example.backend.model.dto.EditCarDto;
import com.example.backend.model.dto.UsernameDto;
import com.example.backend.model.exceptions.CarNotFoundException;
import com.example.backend.repository.CarRepository;
import com.example.backend.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<Car> listAllUnPurchasedCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> addCar(AddCarDto addCarDto) throws JsonProcessingException {
        List<Image> images = new ArrayList<>();
        for (int i = 0; i < addCarDto.getImages().length; i++) {
            try {
                Image image = new Image(addCarDto.getImages()[i].getOriginalFilename(),
                        addCarDto.getImages()[i].getContentType(),
                        addCarDto.getImages()[i].getBytes());
                images.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        Brand brand = mapper.readValue(addCarDto.getBrand(), Brand.class);
        Model model = mapper.readValue(addCarDto.getModel(), Model.class);
        Long emissions = Long.parseLong(addCarDto.getEmissions());
        Long price = Long.parseLong(addCarDto.getEmissions());
        Long year = Long.parseLong(addCarDto.getYear());
        Long quantity = Long.parseLong(addCarDto.getQuantity());
        Car car = new Car(brand,
                model,
                addCarDto.getCarType(),
                addCarDto.getTransmission(),
                addCarDto.getFuelTankType(),
                addCarDto.getEngine(),
                addCarDto.getTires(),
                emissions,
                price,
                year,
                addCarDto.getDescription(),
                quantity,
                images);
        return Optional.of(carRepository.save(car));
    }

    public byte[] getImage(Long id, Integer index) {
        Car car = carRepository.findById(id).orElseThrow();
        return car.getImages().get(index).getData();
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Optional<Car> editCar(EditCarDto editCarDto) {
        Car car = carRepository
                .findById(editCarDto.getId())
                .orElseThrow(() -> new CarNotFoundException(editCarDto.getId()));

        car.setFuelTankType(editCarDto.getFuelTankType());
        car.setEngine(editCarDto.getEngine());
        car.setEmissions(editCarDto.getEmissions());
        car.setTires(editCarDto.getTires());
        car.setPrice(editCarDto.getPrice());
        car.setDescription(editCarDto.getDescription());
        return Optional.of(carRepository.save(car));
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> findAllCarsByUser(UsernameDto usernameDto) {
        return carRepository.findAll()
                .stream()
                .filter(car -> car.getUsers()
                        .stream()
                        .anyMatch(user -> user.getUsername().equals(usernameDto.getUsername())))
                .collect(Collectors.toList());
    }


    @Override
    public Long carsQuantityPurchased(UsernameDto usernameDto, Long id) {
        return carRepository.findAll().stream()
                .filter(car -> car.getId() == id)
                .flatMap(car -> car.getUsers().stream())
                .filter(user -> user.getUsername().equals(usernameDto.getUsername()))
                .count();
    }
}
