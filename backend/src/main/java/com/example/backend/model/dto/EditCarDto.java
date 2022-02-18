package com.example.backend.model.dto;

import com.example.backend.model.enums.FuelTankType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
public class EditCarDto {

    @NotNull
    private Long id;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private FuelTankType fuelTankType;

    @NotNull
    private String engine;

    @NotNull
    private String tires;

    @NotNull
    private Long emissions;

    @NotNull
    private Long price;

    @NotNull
    private String description;

    public EditCarDto(Long id,
                      FuelTankType fuelTankType,
                      String engine,
                      String tires,
                      Long emissions,
                      Long price,
                      String description) {
        this.id = id;
        this.fuelTankType = fuelTankType;
        this.engine = engine;
        this.tires = tires;
        this.emissions = emissions;
        this.price = price;
        this.description = description;
    }
}
