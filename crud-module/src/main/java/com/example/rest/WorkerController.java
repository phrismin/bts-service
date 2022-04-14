package com.example.rest;

import com.example.model.Worker;
import com.example.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//        .../departments - POST, GET
//        .../departments/{id} - GET, DELETE
//        .../worked_hours - POST, GET
//        .../worked_hours/{workerId} - GET, DELETE

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAll() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Worker> save(@RequestBody Worker worker) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Worker> getByID(@PathVariable Long id) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Worker> deleteById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
