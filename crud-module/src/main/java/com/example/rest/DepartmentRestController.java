package com.example.rest;

import com.example.model.Department;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        List<Department> departments = departmentService.getAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Department> save(@RequestBody Department department) {
        Department addWorker = departmentService.add(department);
        return new ResponseEntity<>(addWorker, HttpStatus.CREATED);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Department> getByID(@PathVariable Long id) {
        Department department = departmentService.getById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        departmentService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}