package com.example.repository;

import com.example.model.WorkedHoursEntity;
import org.springframework.data.repository.CrudRepository;

public interface WorkedHoursRepository extends CrudRepository<WorkedHoursEntity, Long> {
}
