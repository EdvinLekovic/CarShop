package com.example.backend.web.rest;

import com.example.backend.model.Brand;
import com.example.backend.model.Car;
import com.example.backend.model.Model;
import com.example.backend.model.dto.AddCarDto;
import com.example.backend.model.dto.EditCarDto;
import com.example.backend.model.dto.UsernameDto;
import com.example.backend.model.enums.CarType;
import com.example.backend.model.enums.FuelTankType;
import com.example.backend.model.enums.Transmission;
import com.example.backend.service.BrandService;
import com.example.backend.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@CrossOrigin("http://localhost:8080")
public class CarResource {

    private final CarService carService;
    private final BrandService brandService;

    public CarResource(CarService carService, BrandService brandService) {
        this.carService = carService;
        this.brandService = brandService;
    }

    @GetMapping
    public List<Car> ListAllCars() {
        return carService.listAllUnPurchasedCars();
    }

    @GetMapping("/car-types")
    public List<CarType> listAllCarTypes() {
        return List.of(CarType.values());
    }

    @GetMapping("/fuel-tank-types")
    public List<FuelTankType> listAllFuelTankTypes() {
        return List.of(FuelTankType.values());
    }

    @GetMapping("/transmissions")
    public List<Transmission> listAllTransmissions() {
        return List.of(Transmission.values());
    }

    @GetMapping("/brands")
    public List<Brand> listAllBrands() {
        return brandService.listAllBrands();
    }

    @GetMapping("/brands/{name}")
    public List<Model> listAllModelsPerBrand(@PathVariable String name) {
        return brandService.listAllModelsByBrand(name);
    }

    @GetMapping("/{id}")
    public Optional<Car> findCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @PostMapping(value = "/add-car", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Optional<Car> addCar(@RequestParam String brand,
                                @RequestParam String model,
                                @RequestParam CarType carType,
                                @RequestParam Transmission transmission,
                                @RequestParam FuelTankType fuelTankType,
                                @RequestParam String engine,
                                @RequestParam String tires,
                                @RequestParam String emissions,
                                @RequestParam String price,
                                @RequestParam String year,
                                @RequestParam String description,
                                @RequestParam String quantity,
                                @RequestParam MultipartFile[] images) throws JsonProcessingException {
        AddCarDto addCarDto =
                new AddCarDto(brand,
                        model,
                        carType,
                        transmission,
                        fuelTankType,
                        engine,
                        tires,
                        emissions,
                        price,
                        year,
                        description,
                        quantity,
                        images);
        return carService.addCar(addCarDto);
    }

    @GetMapping(value = "/get-images-by-car-id/{id}/{index}")
    public byte[] getImage(@PathVariable Long id, @PathVariable Integer index) {
        return carService.getImage(id, index);
    }

    @PostMapping("/edit-car")
    public Optional<Car> editCar(@RequestBody EditCarDto editCarDto) {
        return carService.editCar(editCarDto);
    }

    @DeleteMapping("delete-car/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PostMapping("/users-cars")
    public List<Car> findAllCarsByUser(@RequestBody UsernameDto usernameDto) {
        return carService.findAllCarsByUser(usernameDto);
    }

    @PostMapping("/number-of-owning-same-model/{id}")
    public Long quantityOfOwningSameCarModel(@RequestBody UsernameDto usernameDto, @PathVariable Long id) {
        return carService.carsQuantityPurchased(usernameDto, id);
    }

}
