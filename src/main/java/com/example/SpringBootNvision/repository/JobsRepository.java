package com.example.SpringBootNvision.repository;

import com.example.SpringBootNvision.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long>, JpaSpecificationExecutor<Jobs> {

    Optional<Jobs> findJobsByUserAndTypeAndDeviceAndTime(Jobs jobs);
}
