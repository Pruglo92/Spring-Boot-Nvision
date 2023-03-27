package com.example.SpringBootNvision.service.impl;

import com.example.SpringBootNvision.dto.Jobs;
import com.example.SpringBootNvision.dto.JobsResponseDto;
import com.example.SpringBootNvision.dto.StatisticRequestDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.mapper.JobsMapper;
import com.example.SpringBootNvision.repository.JobsRepository;
import com.example.SpringBootNvision.repository.specification.JobsSpecification;
import com.example.SpringBootNvision.service.JobsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class JobsServiceImpl implements JobsService {

    private final JobsRepository jobsRepository;
    private final JobsMapper jobsMapper;

    @Override
    public List<JobsResponseDto> register(Jobs jobs) {
        var response = jobs.getJobList().stream()
                .map(jobsMapper::toEntity)
                .map(jobsRepository::save)
                .map(jobsMapper::toDto)
                .collect(Collectors.groupingBy(JobsResponseDto::user))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> String.valueOf(e.getValue().stream()
                                .mapToInt(JobsResponseDto::amount)
                                .sum()), (o1, o2) -> o1, TreeMap::new))
                .entrySet().stream()
                .map(JobsResponseDto::new)
                .toList();

        log.info("was registered " + jobs.getJobList().size());
        return response;
    }

    @Override
    public List<StatisticResponseDto> getAllJobs(StatisticRequestDto dto, Sort sort) {
        var jobs = jobsRepository.findAll(new JobsSpecification(dto), sort)
                .stream()
                .map(jobsMapper::toStatisticDto)
                .toList();

        log.info("jobs repository has {} entries", jobs.size());
        return jobs;
    }
}
