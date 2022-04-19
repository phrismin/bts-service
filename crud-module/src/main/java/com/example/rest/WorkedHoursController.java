package com.example.rest;

import com.example.dto.WorkedHoursDto;
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
    public ResponseEntity<List<WorkedHoursDto>> getAll() {
        List<WorkedHoursEntity> workedHourEntities = workedHoursService.getAll();
        List<WorkedHoursDto> workedHoursDtos = workedHourEntities.stream()
                .map(this::getWorkedHoursDto).toList();

        return new ResponseEntity<>(workedHoursDtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<WorkedHoursDto> save(@RequestBody WorkedHoursDto dto) {
        WorkedHoursEntity workedHoursEntity = getWorkedHoursEntity(dto);
        WorkedHoursEntity addWorkedHoursEntity = workedHoursService.add(workedHoursEntity);
        WorkedHoursDto workedHoursDto = getWorkedHoursDto(addWorkedHoursEntity);

        return new ResponseEntity<>(workedHoursDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "{workerId}")
    public ResponseEntity<WorkedHoursDto> getByID(@PathVariable Long workerId) {
        WorkedHoursEntity workedHoursEntity = workedHoursService.getById(workerId);
        WorkedHoursDto workedHoursDto = getWorkedHoursDto(workedHoursEntity);

        return new ResponseEntity<>(workedHoursDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{workerId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long workerId) {
        workedHoursService.deleteByID(workerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public WorkedHoursEntity getWorkedHoursEntity(WorkedHoursDto dto) {
        WorkedHoursEntity workedHoursEntity = new WorkedHoursEntity();
        workedHoursEntity.setId(dto.getId());
        workedHoursEntity.setStartDate(dto.getStartDate());
        workedHoursEntity.setEndDate(dto.getEndDate());
        workedHoursEntity.setWorkerId(dto.getWorkerId());
        return workedHoursEntity;
    }

    public WorkedHoursDto getWorkedHoursDto(WorkedHoursEntity entity) {
        WorkedHoursDto workedHoursDto = new WorkedHoursDto();
        workedHoursDto.setId(entity.getId());
        workedHoursDto.setStartDate(entity.getStartDate());
        workedHoursDto.setEndDate(entity.getEndDate());
        workedHoursDto.setWorkerId(entity.getWorkerId());
        return workedHoursDto;
    }
}
