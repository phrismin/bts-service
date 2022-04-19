package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "workers")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

//    @ManyToOne()
//    @JoinColumn(name = "department_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private DepartmentEntity departmentEntity;

    //    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worker")
//    @JsonManagedReference
//    private List<WorkedHoursEntity> workedHourEntities;
    @Column(name = "department_id")
    public Long departmentId;
}
