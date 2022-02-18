package com.example.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UsernameDto {

    @NotNull
    private String username;

    public UsernameDto(String username) {
        this.username = username;
    }

    public UsernameDto() {}
}
