package com.example.service;

import com.example.model.Worker;
import com.example.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService (WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker getById(Long id) {
       return workerRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("User with this id isn't exist: " + id));
    }

    public Worker add(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker deleteByID(Long id) {
        workerRepository.delete(getById(id));
        return null;
    }

    public List<Worker> getAll() {
        return (List<Worker>) workerRepository.findAll();
    }
}
