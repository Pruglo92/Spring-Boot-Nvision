package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.entity.enums.JobsType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
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

//        @JsonFormat(pattern = DATE_PATTERN)
        @DateTimeFormat(pattern = DATE_PATTERN)
        LocalDateTime time
) {
}
