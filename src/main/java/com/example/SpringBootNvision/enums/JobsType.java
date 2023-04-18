package com.example.SpringBootNvision.enums;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum JobsType {
    @JsonProperty("print")
    PRINT(),
    @JsonProperty("copy")
    COPY(),
    @JsonProperty("scan")
    SCAN(),
    @JsonProperty("fax")
    FAX()
}
