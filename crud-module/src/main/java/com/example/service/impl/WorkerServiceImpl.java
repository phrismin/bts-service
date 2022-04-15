package com.example.service.impl;

import com.example.model.Worker;
import com.example.repository.WorkerRepository;
import com.example.service.WorkerService;
import com.example.service.exception.WorkerServiceException;
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

    public Worker getById(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new WorkerServiceException(
                        String.format("Worker with this id isn't exist: %d", id)
                ));
    }

    public Worker add(Worker worker) {
        return workerRepository.save(worker);
    }

    public void deleteByID(Long id) {
        workerRepository.delete(getById(id));
    }

    public List<Worker> getAll() {
        List<Worker> workers = (List<Worker>) workerRepository.findAll();
        if (workers.isEmpty()) {
            throw new WorkerServiceException("List is empty");
        }
        return workers;
    }
}
