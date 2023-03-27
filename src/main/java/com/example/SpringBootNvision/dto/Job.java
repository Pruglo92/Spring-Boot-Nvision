package com.example.SpringBootNvision.dto;

import com.example.SpringBootNvision.entity.enums.JobsType;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {


    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private Long Id;

    @JacksonXmlProperty
    private JobsType type;

    @JacksonXmlProperty
    private String user;

    @JacksonXmlProperty
    private String device;

    @JacksonXmlProperty
    private Integer amount;
}
