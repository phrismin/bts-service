package com.example.service;

import com.example.model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkerService {

    Worker getById(Long id);

    Worker add(Worker worker);

    void deleteByID(Long id);

    List<Worker> getAll();

}
