package com.example.SpringBootNvision.service;

import com.example.SpringBootNvision.dto.StatisticRequestDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.entity.Jobs;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface JobsService {

    Jobs register(Jobs jobs);

    List<StatisticResponseDto> getAllJobs(StatisticRequestDto dto, Sort sort);

}
