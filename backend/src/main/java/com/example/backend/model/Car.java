package com.example.backend.model;

import com.example.backend.model.enums.CarType;
import com.example.backend.model.enums.FuelTankType;
import com.example.backend.model.enums.Transmission;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<User> users;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Model model;

    @Enumerated(value = EnumType.STRING)
    private CarType carType;

    @Enumerated(value = EnumType.STRING)
    private Transmission transmission;

    @Enumerated(value = EnumType.STRING)
    private FuelTankType fuelTankType;

    private String engine;

    private String tires;

    private Long emissions;

    private Long price;

    private Long year;

    @Column(length = 1000)
    private String description;

    private Long quantity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

    public Car(Brand brand,
               Model model,
               CarType carType,
               Transmission transmission,
               FuelTankType fuelTankType,
               String engine,
               String tires,
               Long emissions,
               Long price,
               Long year,
               String description,
               Long quantity,
               List<Image> images) {
        this.users = new ArrayList<>();
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

    public Car() {
    }
}
