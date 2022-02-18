package com.example.backend.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserEditDto {

    @NotNull
    private String username;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String password;

    @NotNull
    private String repeatPassword;

    public UserEditDto(String username, String name, String lastName, String password) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }
}
