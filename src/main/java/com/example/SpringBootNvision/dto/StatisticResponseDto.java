package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.enums.JobsType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static com.example.SpringBootNvision.utils.DataConstants.DATE_PATTERN;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StatisticResponseDto(

        @NotNull
        Long id,

        @NotBlank
        String device,

        @NotBlank
        String user,

        @NotBlank
        JobsType type,

        @NotNull
        Integer amount,

        @DateTimeFormat(pattern = DATE_PATTERN)
        @JsonFormat(pattern = DATE_PATTERN)
        LocalDateTime time
) {
}
