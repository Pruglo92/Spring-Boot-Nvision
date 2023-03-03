package com.example.SpringBootNvision.mapper;

import com.example.SpringBootNvision.dto.JobsRequestDto;
import com.example.SpringBootNvision.dto.JobsResponseDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.entity.Jobs;
import org.mapstruct.Mapper;

@Mapper
public interface JobsMapper {

    Jobs toEntity(JobsRequestDto dto);

    JobsResponseDto toDto(Jobs entity);

    StatisticResponseDto toStatisticDto(Jobs entity);
}
