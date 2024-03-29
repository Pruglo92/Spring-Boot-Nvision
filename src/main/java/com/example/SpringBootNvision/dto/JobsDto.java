package com.example.SpringBootNvision.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@JacksonXmlRootElement(localName = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobsDto {

    @Schema(name = "job")
    @JacksonXmlProperty(localName = "job")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<JobDto> jobDtoList;
}
