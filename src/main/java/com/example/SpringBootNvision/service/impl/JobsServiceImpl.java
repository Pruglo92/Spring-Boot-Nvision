package com.example.SpringBootNvision.service.impl;

import com.example.SpringBootNvision.entity.Jobs;
import com.example.SpringBootNvision.repository.JobsRepository;
import com.example.SpringBootNvision.service.JobsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class JobsServiceImpl implements JobsService {

    private final JobsRepository jobsRepository;

    @Override
    public Jobs register(Jobs jobs) {
        var savedJobs = jobsRepository.save(jobs);
        log.info("was registered " + jobs);
        return savedJobs;
    }

    @Override
    public List<Jobs> getAllJobs() {
        var jobs = jobsRepository.findAll();
        log.info("jobs repository has {} entries", jobs.size());
        return jobs;
    }

    @Override
    public List<Jobs> getAllJobsWithFilter(Map<String, String> map) {

        return null;
    }

}
