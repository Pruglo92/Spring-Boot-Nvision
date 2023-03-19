package com.example.SpringBootNvision.entity;

import com.example.SpringBootNvision.entity.enums.JobsType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "jobs")
public class Jobs extends BaseEntity {

    @NonNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private JobsType type;

    @NonNull
    @Column(name = "user")
    private String user;

    @NonNull
    @Column(name = "device")
    private String device;

    @NonNull
    @Column(name = "amount")
    private Integer amount;

    @NonNull
    @Column(name = "time")
    @CreatedDate
    private LocalDateTime time;
}
