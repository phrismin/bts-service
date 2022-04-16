package com.example.service;

import com.example.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    Department getById(Long id);

    Department add(Department department);

    void deleteByID(Long id);

    List<Department> getAll();

}