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

    public static final String DATE_PATTERN = "dd.MM.yyyy HH:mm";
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
    @DateTimeFormat(pattern = DATE_PATTERN)
    @JsonFormat(pattern = DATE_PATTERN)
    @CreatedDate
    private LocalDateTime time;
}
