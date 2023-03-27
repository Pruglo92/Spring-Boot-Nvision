package com.example.SpringBootNvision.service;

import com.example.SpringBootNvision.dto.Jobs;
import com.example.SpringBootNvision.dto.JobsResponseDto;
import com.example.SpringBootNvision.dto.StatisticRequestDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface JobsService {

    List<JobsResponseDto> register(Jobs jobs);

    List<StatisticResponseDto> getAllJobs(StatisticRequestDto dto, Sort sort);

}
