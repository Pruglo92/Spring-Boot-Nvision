package com.example.SpringBootNvision.repository.specification;

import com.example.SpringBootNvision.dto.StatisticRequestDto;
import com.example.SpringBootNvision.entity.JobsEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class JobsSpecification implements Specification<JobsEntity> {

    private final StatisticRequestDto statisticRequestDto;

    @Override
    public Predicate toPredicate(@NonNull Root<JobsEntity> root,
                                 @NonNull CriteriaQuery<?> query,
                                 @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (statisticRequestDto.device() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("device")),
                    statisticRequestDto.device().toUpperCase()));
        }
        if (statisticRequestDto.user() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("user")),
                    statisticRequestDto.user().toUpperCase()));
        }
        if (statisticRequestDto.type() != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("type")),
                    statisticRequestDto.type().name()));
        }
        if (statisticRequestDto.timeFrom() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("time"),
                    statisticRequestDto.timeFrom()));
        }
        if (statisticRequestDto.timeTo() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("time"),
                    statisticRequestDto.timeTo()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
