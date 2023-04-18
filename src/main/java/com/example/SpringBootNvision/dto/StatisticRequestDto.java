package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.enums.JobsType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

import static com.example.SpringBootNvision.utils.DataConstants.DATE_PATTERN;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StatisticRequestDto(

        @NotBlank
        String device,

        @NotBlank
        String user,

        @NotBlank
        JobsType type,

        @DateTimeFormat(pattern = DATE_PATTERN)
        LocalDateTime timeFrom,

        @DateTimeFormat(pattern = DATE_PATTERN)
        LocalDateTime timeTo
) {
}
