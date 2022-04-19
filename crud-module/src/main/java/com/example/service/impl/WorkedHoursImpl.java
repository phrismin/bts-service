package com.example.service.impl;

import com.example.model.WorkedHoursEntity;
import com.example.repository.WorkedHoursRepository;
import com.example.service.WorkedHoursService;
import com.example.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkedHoursImpl implements WorkedHoursService {

    private final WorkedHoursRepository workedHoursRepository;

    @Autowired
    public WorkedHoursImpl(WorkedHoursRepository workedHoursRepository) {
        this.workedHoursRepository = workedHoursRepository;
    }

    @Override
    public WorkedHoursEntity getById(Long id) {
//        Optional<WorkedHoursEntity> optionalWorkedHours = workedHoursRepository.findById(id);
//        if (optionalWorkedHours.isPresent()) {
//            return optionalWorkedHours.get();
//        } else {
//            throw new ServiceException(String.format(
//                    "Worked hours with this id isn't exist: %d", id
//            ));
//        }
        return workedHoursRepository.findById(id)
                .orElseThrow(() -> new ServiceException(
                        String.format("Worked hours with this id isn't exist: %d", id)
                ));
    }

    @Override
    public WorkedHoursEntity add(WorkedHoursEntity workedHoursEntity) {
        return workedHoursRepository.save(workedHoursEntity);
    }

    @Override
    public void deleteByID(Long id) {
        workedHoursRepository.delete(getById(id));
    }

    @Override
    public List<WorkedHoursEntity> getAll() {
        List<WorkedHoursEntity> workedHourEntities = (List<WorkedHoursEntity>) workedHoursRepository.findAll();
        if (workedHourEntities.isEmpty()) {
            throw new ServiceException("List is empty");
        }
        return workedHourEntities;
    }
}
