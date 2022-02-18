package com.example.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AnswerServiceRequestDto {
    @NotNull
    private String answer;

    public AnswerServiceRequestDto(String answer) {
        this.answer = answer;
    }

    public AnswerServiceRequestDto() {
    }
}
