package com.example.SpringBootNvision.service;

import com.example.SpringBootNvision.entity.Jobs;

import java.util.List;
import java.util.Map;

public interface JobsService {

    Jobs register(Jobs jobs);

    List<Jobs> getAllJobs();

    List<Jobs> getAllJobsWithFilter(Map<String, String> map);
}
