package com.example.SpringBootNvision.controllers;

import com.example.SpringBootNvision.dto.JobsRequestDto;
import com.example.SpringBootNvision.dto.JobsResponseDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.mapper.JobsMapper;
import com.example.SpringBootNvision.service.JobsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<List<StatisticResponseDto>>getJobs(
            @RequestParam Map<String, String> requestParams) {
        if (requestParams.isEmpty()) {
            var jobs = jobsService.getAllJobs()
                    .stream()
                    .map(jobsMapper::toStatisticDto)
                    .toList();
            return ResponseEntity.ok(jobs);
        }else {
            var allJobsWithFilter = jobsService.getAllJobsWithFilter(requestParams)
                    .stream()
                    .map(jobsMapper::toStatisticDto)
                    .toList();
            return ResponseEntity.ok(allJobsWithFilter);
        }
    }
}
