package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.entity.enums.JobsType;
import javax.validation.constraints.*;

public record JobsRequestDto(

        @NotBlank
        JobsType type,

        @NotBlank
        String user,

        @NotBlank
        String device,

        @NotBlank
        Integer amount
) {
}
