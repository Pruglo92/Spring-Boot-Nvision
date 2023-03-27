package com.example.SpringBootNvision.controllers;

import com.example.SpringBootNvision.dto.Jobs;
import com.example.SpringBootNvision.dto.JobsResponseDto;
import com.example.SpringBootNvision.dto.StatisticRequestDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.service.JobsService;
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

    @PostMapping(path = "/jobs",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<JobsResponseDto>> createJobs(
            @Valid @RequestBody Jobs jobs) {
        return ResponseEntity.ok(jobsService.register(jobs));
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<StatisticResponseDto>> getJobs(
            @Valid @ModelAttribute StatisticRequestDto dto, Sort sort) {
        return ResponseEntity.ok(jobsService.getAllJobs(dto, sort));
    }
}
