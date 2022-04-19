package com.example.dto;

import com.example.model.WorkedHoursEntity;
import com.example.model.WorkerEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkerDto extends BaseDto {

    private String firstName;
    private String lastName;

    private Long departmentId;

    public WorkerEntity toWorkerEntity() {
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setId(id);
        workerEntity.setFirstName(firstName);
        workerEntity.setLastName(lastName);
        workerEntity.setDepartmentId(departmentId);
        return workerEntity;
    }

    public static WorkerDto fromWorkerEntity(WorkerEntity entity) {
        WorkerDto workerDto = new WorkerDto();
        workerDto.setId(entity.getId());
        workerDto.setFirstName(entity.getFirstName());
        workerDto.setLastName(entity.getLastName());
        workerDto.setDepartmentId(entity.getDepartmentId());
        return workerDto;
    }

}
