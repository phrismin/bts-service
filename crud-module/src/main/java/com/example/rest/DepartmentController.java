package com.example.rest;

import com.example.dto.DepartmentDto;
import com.example.model.DepartmentEntity;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll() {
        List<DepartmentEntity> departmentEntities = departmentService.getAll();
        List<DepartmentDto> departmentDtos = departmentEntities.stream()
                .map(this::getDepartmentDto).toList();

        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto dto) {

        DepartmentEntity departmentEntity = getDepartmentEntity(dto);
        DepartmentEntity department = departmentService.add(departmentEntity);
        DepartmentDto departmentDto = getDepartmentDto(department);

        return new ResponseEntity<>(departmentDto, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DepartmentDto> getByID(@PathVariable Long id) {
        DepartmentEntity departmentEntity = departmentService.getById(id);
        DepartmentDto departmentDto = getDepartmentDto(departmentEntity);

        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        departmentService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private DepartmentEntity getDepartmentEntity(DepartmentDto dto) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(dto.getId());
        departmentEntity.setName(dto.getName());
        return departmentEntity;
    }

    private DepartmentDto getDepartmentDto(DepartmentEntity entity) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(entity.getId());
        departmentDto.setName(entity.getName());
        return departmentDto;
    }
}