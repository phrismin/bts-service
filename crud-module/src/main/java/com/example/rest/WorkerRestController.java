package com.example.rest;

import com.example.model.Worker;
import com.example.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerRestController {

    private final WorkerService workerService;

    @Autowired
    public WorkerRestController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAll() {
        List<Worker> workers = workerService.getAll();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Worker> save(@RequestBody Worker worker) {
        Worker addWorker = workerService.add(worker);
        return new ResponseEntity<>(addWorker, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Worker> getByID(@PathVariable Long id) {
        Worker worker = workerService.getById(id);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        workerService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
