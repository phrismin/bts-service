package com.example.rest;

import com.example.model.WorkedHoursEntity;
import com.example.service.WorkedHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workedHours")
public class WorkedHoursController {

    private final WorkedHoursService workedHoursService;

    @Autowired
    public WorkedHoursController(WorkedHoursService workedHoursService) {
        this.workedHoursService = workedHoursService;
    }

    @GetMapping
    public ResponseEntity<List<WorkedHoursEntity>> getAll() {
        List<WorkedHoursEntity> workedHourEntities = workedHoursService.getAll();
        return new ResponseEntity<>(workedHourEntities, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<WorkedHoursEntity> save(@RequestBody WorkedHoursEntity workedHoursEntity) {
        WorkedHoursEntity addWorkedHoursEntity = workedHoursService.add(workedHoursEntity);
        return new ResponseEntity<>(addWorkedHoursEntity, HttpStatus.CREATED);
    }

    @GetMapping(value = "{workerId}")
    public ResponseEntity<WorkedHoursEntity> getByID(@PathVariable Long workerId) {
        WorkedHoursEntity workedHoursEntity = workedHoursService.getById(workerId);
        return new ResponseEntity<>(workedHoursEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = "{workerId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long workerId) {
        workedHoursService.deleteByID(workerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
