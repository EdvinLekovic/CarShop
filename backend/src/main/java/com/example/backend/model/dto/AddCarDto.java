package com.example.backend.model.dto;

import com.example.backend.model.Brand;
import com.example.backend.model.Model;
import com.example.backend.model.User;
import com.example.backend.model.enums.CarType;
import com.example.backend.model.enums.FuelTankType;
import com.example.backend.model.enums.Transmission;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
public class AddCarDto {

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private CarType carType;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private FuelTankType fuelTankType;

    @NotNull
    private String engine;

    @NotNull
    private String tires;

    @NotNull
    private String emissions;

    @NotNull
    private String price;

    @NotNull
    private String year;

    @NotNull
    private String description;

    @NotNull
    private String quantity;

    @NotNull
    private MultipartFile[] images;


    public AddCarDto(String brand,
                     String model,
                     CarType carType,
                     Transmission transmission,
                     FuelTankType fuelTankType,
                     String engine,
                     String tires,
                     String emissions,
                     String price,
                     String year,
                     String description,
                     String quantity,
                     @NotNull MultipartFile[] images) {
        this.brand = brand;
        this.model = model;
        this.carType = carType;
        this.transmission = transmission;
        this.fuelTankType = fuelTankType;
        this.engine = engine;
        this.tires = tires;
        this.emissions = emissions;
        this.price = price;
        this.year = year;
        this.description = description;
        this.quantity = quantity;
        this.images = images;
    }
}
