package com.example;

import com.example.model.Department;
import com.example.model.Worker;
import com.example.repository.DepartmentRepository;
import com.example.repository.WorkerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrudModuleRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CrudModuleRunner.class, args);
        WorkerRepository workerRepository = context.getBean(WorkerRepository.class);
        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);

        Department department = Department.builder()
                .name("1-st department")
                .build();
        departmentRepository.save(department);

        Worker worker = Worker.builder()
                .firstname("aLEX")
                .lastname("Valex")
                .department(department)
                .build();
        workerRepository.save(worker);
    }
}
