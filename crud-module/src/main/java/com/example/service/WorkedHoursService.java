package com.example.service;

import com.example.model.WorkedHoursEntity;

import java.util.List;

public interface WorkedHoursService {

    WorkedHoursEntity getById(Long id);

    WorkedHoursEntity add(WorkedHoursEntity workedHoursEntity);

    void deleteByID(Long id);

    List<WorkedHoursEntity> getAll();

}
