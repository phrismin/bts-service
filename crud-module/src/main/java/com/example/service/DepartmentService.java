package com.example.service;

import com.example.model.DepartmentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    DepartmentEntity getById(Long id);

    DepartmentEntity add(DepartmentEntity departmentEntity);

    void deleteByID(Long id);

    List<DepartmentEntity> getAll();

}