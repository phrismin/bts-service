package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "worked_hours")
public class WorkedHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "worker_id")
//    @JsonBackReference
//    private WorkerEntity workerEntity;
    @Column(name = "worker_id")
    private Long workerId;
}
