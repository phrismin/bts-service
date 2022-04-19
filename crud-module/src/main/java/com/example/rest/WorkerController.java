package com.example.rest;

import com.example.dto.WorkerDto;
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
    public ResponseEntity<List<WorkerDto>> getAll() {
        List<WorkerEntity> workerEntities = workerService.getAll();
        List<WorkerDto> workerDtos = workerEntities.stream()
                .map(this::getWorkerDto).toList();

        return new ResponseEntity<>(workerDtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<WorkerDto> save(@RequestBody WorkerDto dto) {
        WorkerEntity workerEntity = getWorkerEntity(dto);
        WorkerEntity addWorkerEntity = workerService.add(workerEntity);
        WorkerDto workerDto = getWorkerDto(addWorkerEntity);

        return new ResponseEntity<>(workerDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<WorkerDto> getByID(@PathVariable Long id) {
        WorkerEntity workerEntity = workerService.getById(id);
        WorkerDto workerDto = getWorkerDto(workerEntity);

        return new ResponseEntity<>(workerDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        workerService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public WorkerEntity getWorkerEntity(WorkerDto dto) {
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setId(dto.getId());
        workerEntity.setFirstName(dto.getFirstName());
        workerEntity.setLastName(dto.getLastName());
        workerEntity.setDepartmentId(dto.getDepartmentId());
        return workerEntity;
    }

    public WorkerDto getWorkerDto(WorkerEntity entity) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.setId(entity.getId());
        workerDto.setFirstName(entity.getFirstName());
        workerDto.setLastName(entity.getLastName());
        workerDto.setDepartmentId(entity.getDepartmentId());
        return workerDto;
    }
}
