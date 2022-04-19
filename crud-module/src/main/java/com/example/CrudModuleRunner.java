package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrudModuleRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CrudModuleRunner.class, args);
//        WorkerRepository workerRepository = context.getBean(WorkerRepository.class);
//        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
//        WorkedHoursRepository workedHoursRepository = context.getBean(WorkedHoursRepository.class);
//
//        Department department = Department.builder()
//                .name("2-st department")
//                .build();
//        departmentRepository.save(department);
//
//        WorkerEntity worker1 = WorkerEntity.builder()
//                .firstName("aLEX")
//                .lastName("Valex")
//                .department(department)
//                .build();
//        workerRepository.save(worker1);
//
//        WorkerEntity worker2 = WorkerEntity.builder()
//                .firstName("Riahanna")
//                .lastName("Pina")
//                .department(department)
//                .build();
//        workerRepository.save(worker2);
//
//        LocalDateTime startDate = LocalDateTime.of(2022, 4, 12, 10, 21, 55);
//        LocalDateTime endDate = LocalDateTime.of(2022, 4, 12, 18, 54, 2);
//        WorkedHoursEntity workedHourEntities = WorkedHoursEntity.builder()
//                .startDate(startDate)
//                .endDate(endDate)
//                .workerEntity(worker1)
//                .build();
//        workedHoursRepository.save(workedHourEntities);

    }
}
