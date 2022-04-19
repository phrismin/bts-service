package com.example.service;

import com.example.model.WorkerEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkerService {

    WorkerEntity getById(Long id);

    WorkerEntity add(WorkerEntity workerEntity);

    void deleteByID(Long id);

    List<WorkerEntity> getAll();

}
