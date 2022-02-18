package com.example.backend.model.dto;

import com.example.backend.model.Brand;
import com.example.backend.model.Model;
import com.example.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;


@Data
public class ReviewDto {

    @NotNull
    private String username;

    @NotNull
    private String model;

    @NotNull
    private String brand;

    @NotNull
    private String rating;

    @NotNull
    private String description;

    @NotNull
    private MultipartFile image;

    public ReviewDto(String username, String model, String brand, String rating, String description, MultipartFile image) {
        this.username = username;
        this.model = model;
        this.brand = brand;
        this.rating = rating;
        this.description = description;
        this.image = image;
    }

    public ReviewDto() {}
}
