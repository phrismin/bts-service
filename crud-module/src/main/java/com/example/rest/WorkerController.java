package com.example.rest;

import com.example.model.WorkerEntity;
import com.example.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<WorkerEntity>> getAll() {
        List<WorkerEntity> workerEntities = workerService.getAll();
        return new ResponseEntity<>(workerEntities, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<WorkerEntity> save(@RequestBody WorkerEntity workerEntity) {
        WorkerEntity addWorkerEntity = workerService.add(workerEntity);
        return new ResponseEntity<>(addWorkerEntity, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<WorkerEntity> getByID(@PathVariable Long id) {
        WorkerEntity workerEntity = workerService.getById(id);
        return new ResponseEntity<>(workerEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        workerService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
