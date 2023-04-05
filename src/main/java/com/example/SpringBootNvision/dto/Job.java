package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.entity.enums.JobsType;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private Long Id;

    @Schema(defaultValue = "fax")
    @JacksonXmlProperty
    private JobsType type;

    @Schema(defaultValue = "user1")
    @JacksonXmlProperty
    private String user;

    @Schema(defaultValue = "device1")
    @JacksonXmlProperty
    private String device;

    @Schema(defaultValue = "20")
    @JacksonXmlProperty
    private Integer amount;
}
