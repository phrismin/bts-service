package com.example.service.impl;

import com.example.model.Department;
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
    public Department getById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ServiceException(
                        String.format("Department with this id isn't exist: %d", id)
                ));
    }

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteByID(Long id) {
        departmentRepository.delete(getById(id));
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = (List<Department>) departmentRepository.findAll();
        if (departments.isEmpty()) {
            throw new ServiceException("List is empty");
        }
        return departments;
    }
}
