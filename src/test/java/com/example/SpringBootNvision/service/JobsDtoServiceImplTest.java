package com.example.SpringBootNvision.service;

import com.example.SpringBootNvision.dto.*;
import com.example.SpringBootNvision.entity.JobsEntity;
import com.example.SpringBootNvision.enums.JobsType;
import com.example.SpringBootNvision.mapper.JobsMapper;
import com.example.SpringBootNvision.repository.JobsRepository;
import com.example.SpringBootNvision.repository.specification.JobsSpecification;
import com.example.SpringBootNvision.service.impl.JobsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JobsDtoServiceImplTest {

    @Mock
    private JobsRepository jobsRepository;

    @Mock
    private JobsMapper jobsMapper;

    @InjectMocks
    private JobsServiceImpl jobsServiceImpl;


    @Test
    @DisplayName("Register All Jobs")
    public void givenJobs_whenRegister_thenSaveJobsAndReturnJobsResponseDtoList() {
        var jobs = new JobsDto(List.of(new JobDto(1L, JobsType.FAX, "user", "device", 10)));
        var jobsResponseDto = new JobsResponseDto("user", 10);

        var expectedResponse = List.of(jobsResponseDto);

        when(jobsMapper.toEntity(any(JobDto.class))).thenReturn(new JobsEntity());
        when(jobsRepository.save(any(JobsEntity.class))).thenReturn(new JobsEntity());
        when(jobsMapper.toDto(any(JobsEntity.class))).thenReturn(jobsResponseDto);

        var response = jobsServiceImpl.register(jobs);

        Assertions.assertEquals(expectedResponse, response);
        verify(jobsMapper, times(1)).toEntity(any(JobDto.class));
        verify(jobsRepository, times(1)).save(any(JobsEntity.class));
        verify(jobsMapper, times(1)).toDto(any(JobsEntity.class));
    }

    @Test
    @DisplayName("Get All Jobs With Specification And Sort")
    public void givenStatisticRequestDtoAndSort_whenGetAllJobs_thenReturnStatisticResponseDtoList() {
        var sort = Sort.by(Sort.Direction.ASC, "id");
        var statisticRequestDto =
                new StatisticRequestDto("device", "user", JobsType.FAX, LocalDateTime.now(), LocalDateTime.now());
        var statisticResponseDto =
                new StatisticResponseDto(1L, "device", "user",JobsType.FAX, 10,LocalDateTime.now());
        when(jobsRepository.findAll(any(JobsSpecification.class), any(Sort.class)))
                .thenReturn(Collections.singletonList(new JobsEntity()));
        when(jobsMapper.toStatisticDto(any())).thenReturn(statisticResponseDto);

        var response = jobsServiceImpl.getAllJobs(statisticRequestDto, sort);
        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals("user", response.get(0).user());
        Assertions.assertEquals(Optional.of(10).get(), response.get(0).amount());

        verify(jobsRepository, times(1)).findAll(any(JobsSpecification.class), any(Sort.class));
        verify(jobsMapper, times(1)).toStatisticDto(any());
    }
}
