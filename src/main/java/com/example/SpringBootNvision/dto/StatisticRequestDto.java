package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.entity.enums.JobsType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record StatisticRequestDto(

        @NotBlank
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String device,

        @NotBlank
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String user,

        @NotBlank
        @JsonInclude(JsonInclude.Include.NON_NULL)
        JobsType type,

        @PastOrPresent
        @JsonInclude(JsonInclude.Include.NON_NULL)
        LocalDateTime timeFrom,

        @PastOrPresent
        @JsonInclude(JsonInclude.Include.NON_NULL)
        LocalDateTime timeTo
) {
}
