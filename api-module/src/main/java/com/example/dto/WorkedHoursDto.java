package com.example.dto;

import com.example.model.WorkedHoursEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkedHoursDto extends BaseDto {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long workerId;

    public WorkedHoursEntity toWorkedHoursEntity() {
        WorkedHoursEntity workedHoursEntity = new WorkedHoursEntity();
        workedHoursEntity.setId(id);
        workedHoursEntity.setStartDate(startDate);
        workedHoursEntity.setEndDate(endDate);
        workedHoursEntity.setWorkerId(workerId);
        return workedHoursEntity;
    }

    public static WorkedHoursDto fromWorkedHoursEntity(WorkedHoursEntity entity) {
        WorkedHoursDto workedHoursDto = new WorkedHoursDto();
        workedHoursDto.setId(entity.getId());
        workedHoursDto.setStartDate(entity.getStartDate());
        workedHoursDto.setEndDate(entity.getEndDate());
        workedHoursDto.setWorkerId(entity.getWorkerId());
        return workedHoursDto;
    }

}
