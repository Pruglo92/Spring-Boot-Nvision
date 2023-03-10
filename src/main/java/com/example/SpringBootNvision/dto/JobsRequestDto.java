package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.entity.enums.JobsType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


//@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public record JobsRequestDto(

        @NotNull
//        @XmlAttribute(name = "id")
        Long id,

        @NotBlank(message = "Unknown type")
//        @XmlElement(name = "type")
        JobsType type,

        @NotBlank
//        @XmlElement(name = "user")
        String user,

        @NotBlank
//        @XmlElement(name = "device")
        String device,

        @NotNull
//        @XmlElement(name = "amount")
        Integer amount
) {
}
