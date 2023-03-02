package com.example.SpringBootNvision.entity;

import com.example.SpringBootNvision.entity.enums.JobsType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "jobs")
public class Jobs extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private JobsType type;

    @Column
    private String user;

    @Column
    private String device;

    @Column
    private Integer amount;

    @Column
    @CreatedDate
    private LocalDateTime time;
}
