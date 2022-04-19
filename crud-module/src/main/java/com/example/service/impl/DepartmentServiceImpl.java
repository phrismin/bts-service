package com.example.service.impl;

import com.example.model.DepartmentEntity;
import com.example.repository.DepartmentRepository;
import com.example.service.DepartmentService;
import com.example.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentEntity getById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ServiceException(
                        String.format("Department with this id isn't exist: %d", id)
                ));
    }

    @Override
    public DepartmentEntity add(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public void deleteByID(Long id) {
        departmentRepository.delete(getById(id));
    }

    @Override
    public List<DepartmentEntity> getAll() {
        List<DepartmentEntity> departmentEntities = (List<DepartmentEntity>) departmentRepository.findAll();
        if (departmentEntities.isEmpty()) {
            throw new ServiceException("List is empty");
        }
        return departmentEntities;
    }
}
