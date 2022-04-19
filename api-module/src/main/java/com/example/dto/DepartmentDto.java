package com.example.dto;

import com.example.model.DepartmentEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentDto extends BaseDto {

    public String name;

    public DepartmentEntity toDepartmentEntity() {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(id);
        departmentEntity.setName(name);
        return departmentEntity;
    }

    public static DepartmentDto fromDepartmentEntity(DepartmentEntity entity) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(entity.getId());
        departmentDto.setName(entity.getName());
        return departmentDto;
    }
}
