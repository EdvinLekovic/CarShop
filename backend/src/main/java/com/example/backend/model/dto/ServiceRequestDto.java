package com.example.backend.model.dto;

import com.example.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ServiceRequestDto {

    @NotNull
    private UsernameDto usernameDto;

    @NotNull
    private String serviceType;

    @NotNull
    private String description;


    public ServiceRequestDto(UsernameDto usernameDto, String serviceType, String description) {
        this.usernameDto = usernameDto;
        this.serviceType = serviceType;
        this.description = description;
    }

}
