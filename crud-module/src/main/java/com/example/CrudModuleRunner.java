package com.example;

import com.example.model.Department;
import com.example.model.WorkedHours;
import com.example.model.Worker;
import com.example.repository.DepartmentRepository;
import com.example.repository.WorkedHoursRepository;
import com.example.repository.WorkerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;

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
//        Worker worker1 = Worker.builder()
//                .firstName("aLEX")
//                .lastName("Valex")
//                .department(department)
//                .build();
//        workerRepository.save(worker1);
//
//        Worker worker2 = Worker.builder()
//                .firstName("Riahanna")
//                .lastName("Pina")
//                .department(department)
//                .build();
//        workerRepository.save(worker2);
//
//        LocalDateTime startDate = LocalDateTime.of(2022, 4, 12, 10, 21, 55);
//        LocalDateTime endDate = LocalDateTime.of(2022, 4, 12, 18, 54, 2);
//        WorkedHours workedHours = WorkedHours.builder()
//                .startDate(startDate)
//                .endDate(endDate)
//                .worker(worker1)
//                .build();
//        workedHoursRepository.save(workedHours);

    }
}
