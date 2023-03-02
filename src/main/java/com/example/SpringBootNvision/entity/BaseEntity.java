package com.example.SpringBootNvision.entity;

import jakarta.persistence.*;
import lombok.*;


@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
