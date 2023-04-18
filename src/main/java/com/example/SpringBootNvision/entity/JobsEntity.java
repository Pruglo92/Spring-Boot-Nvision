package com.example.SpringBootNvision.entity;

import com.example.SpringBootNvision.enums.JobsType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "jobs")
public class JobsEntity extends BaseEntity {

    @NonNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private JobsType type;

    @NonNull
    @Column(name = "\"user\"")
    private String user;

    @NonNull
    @Column(name = "device")
    private String device;

    @NonNull
    @Column(name = "amount")
    private Integer amount;

    @Column(name = "time", nullable = false, updatable = false)
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        JobsEntity that = (JobsEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
