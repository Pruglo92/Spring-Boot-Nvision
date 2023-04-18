package com.example.SpringBootNvision.mapper;

import com.example.SpringBootNvision.dto.Job;
import com.example.SpringBootNvision.dto.JobsResponseDto;
import com.example.SpringBootNvision.dto.StatisticResponseDto;
import com.example.SpringBootNvision.entity.JobsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface JobsMapper {
    @Mapping(target = "time", ignore = true)
    JobsEntity toEntity(Job job);

    JobsResponseDto toDto(JobsEntity entity);

    StatisticResponseDto toStatisticDto(JobsEntity entity);
}
