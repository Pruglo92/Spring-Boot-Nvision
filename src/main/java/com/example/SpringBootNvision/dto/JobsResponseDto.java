package com.example.SpringBootNvision.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JobsResponseDto(

        @NotBlank
        String user,

        @NotBlank
        Integer amount
) {
}
