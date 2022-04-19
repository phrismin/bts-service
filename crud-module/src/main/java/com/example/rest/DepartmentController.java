package com.example.rest;

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
    public ResponseEntity<List<DepartmentEntity>> getAll() {
        List<DepartmentEntity> departmentEntities = departmentService.getAll();
        return new ResponseEntity<>(departmentEntities, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DepartmentEntity> save(@RequestBody DepartmentEntity departmentEntity) {
        DepartmentEntity addWorker = departmentService.add(departmentEntity);
        return new ResponseEntity<>(addWorker, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<DepartmentEntity> getByID(@PathVariable Long id) {
        DepartmentEntity departmentEntity = departmentService.getById(id);
        return new ResponseEntity<>(departmentEntity, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        departmentService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}