package com.example.SpringBootNvision.service.impl;

import com.example.SpringBootNvision.dto.StatisticRequestDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.entity.Jobs;
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


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class JobsServiceImpl implements JobsService {

    private final JobsRepository jobsRepository;
    private final JobsMapper jobsMapper;

    @Override
    public Jobs register(Jobs jobs) {
        var savedJobs = jobsRepository.save(jobs);
        log.info("was registered " + jobs);
        return savedJobs;
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
