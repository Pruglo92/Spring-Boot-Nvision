package com.example.SpringBootNvision.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JobsResponseDto(

        @NotBlank
        String user,

        @NotBlank
        Integer amount
) {
    public JobsResponseDto(Map.Entry<String, String> entry) {
        this(entry.getKey(), Integer.valueOf(entry.getValue()));
    }
}
