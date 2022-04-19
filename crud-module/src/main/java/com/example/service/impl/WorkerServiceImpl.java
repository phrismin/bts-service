package com.example.service.impl;

import com.example.model.WorkerEntity;
import com.example.repository.WorkerRepository;
import com.example.service.WorkerService;
import com.example.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public WorkerEntity getById(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new ServiceException(
                        String.format("WorkerEntity with this id isn't exist: %d", id)
                ));
    }

    public WorkerEntity add(WorkerEntity workerEntity) {
        return workerRepository.save(workerEntity);
    }

    public void deleteByID(Long id) {
        workerRepository.delete(getById(id));
    }

    public List<WorkerEntity> getAll() {
        List<WorkerEntity> workerEntities = (List<WorkerEntity>) workerRepository.findAll();
        if (workerEntities.isEmpty()) {
            throw new ServiceException("List is empty");
        }
        return workerEntities;
    }
}
