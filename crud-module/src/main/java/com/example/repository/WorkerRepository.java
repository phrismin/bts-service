package com.example.repository;

import com.example.model.WorkerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<WorkerEntity, Long> {
}
