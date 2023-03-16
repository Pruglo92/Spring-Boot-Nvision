package com.example.SpringBootNvision.controllers;

import com.example.SpringBootNvision.dto.JobsRequestDto;
import com.example.SpringBootNvision.dto.JobsResponseDto;
import com.example.SpringBootNvision.dto.StatisticRequestDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.mapper.JobsMapper;
import com.example.SpringBootNvision.service.JobsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobsController {

    private final JobsMapper jobsMapper;
    private final JobsService jobsService;

    @Transactional
    @PostMapping(value = "/jobs",
            consumes = MediaType.APPLICATION_ATOM_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<JobsResponseDto> createJobs(
            @Valid @RequestBody JobsRequestDto dto) {
        var jobs = jobsMapper.toEntity(dto);
        var registeredJobs = jobsService.register(jobs);
        var result = jobsMapper.toDto(registeredJobs);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/statistics")
    public ResponseEntity<List<StatisticResponseDto>> getJobs(
            @Valid @ModelAttribute StatisticRequestDto dto, Sort sort) {
        return ResponseEntity.ok(jobsService.getAllJobs(dto, sort));
    }
}
