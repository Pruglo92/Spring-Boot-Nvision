package com.example.SpringBootNvision.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
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
public class Jobs {

    @JacksonXmlProperty(localName = "job")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Job> jobList;
}
