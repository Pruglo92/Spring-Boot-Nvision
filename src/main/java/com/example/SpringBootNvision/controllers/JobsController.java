package com.example.SpringBootNvision.controllers;

import com.example.SpringBootNvision.dto.Jobs;
import com.example.SpringBootNvision.dto.JobsResponseDto;
import com.example.SpringBootNvision.dto.StatisticRequestDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.service.JobsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobsController {

    private final JobsService jobsService;

    @Operation(summary = "Save jobs and get jobs users with amount of pages")
    @PostMapping(path = "/jobs",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<JobsResponseDto>> createJobs(
            @Parameter(in = ParameterIn.DEFAULT,
                    required = true,
                    schema = @Schema()) @Valid @RequestBody Jobs jobs) {
        return ResponseEntity.ok(jobsService.register(jobs));
    }

    @Operation(summary = "Get statistics")
    @GetMapping("/statistics")
    public ResponseEntity<List<StatisticResponseDto>> getJobs(
            @Parameter(in = ParameterIn.DEFAULT,
                    schema = @Schema()) @Valid @ModelAttribute StatisticRequestDto dto, Sort sort) {
        return ResponseEntity.ok(jobsService.getAllJobs(dto, sort));
    }
}
