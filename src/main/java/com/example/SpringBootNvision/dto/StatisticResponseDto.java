package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.entity.enums.JobsType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StatisticResponseDto(

        @NotNull
        @Positive
        Long id,

        @NotBlank
        String device,

        @NotBlank
        String user,

        @NotBlank
        JobsType type,

        @NotNull
        Integer amount,

        @PastOrPresent
        LocalDateTime time
) {
}
