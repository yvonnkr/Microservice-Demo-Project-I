package com.yvolabs.departmentservice.controller;

import com.yvolabs.departmentservice.client.EmployeeClient;
import com.yvolabs.departmentservice.model.Department;
import com.yvolabs.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentRepository repository;
    private final EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        log.info("Department add: {}", department);
        return repository.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll() {
        log.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        log.info("Department find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        log.info("Department find with-employees");
        List<Department> departments = repository.findAll();
        departments.forEach(department ->
                department.setEmployees(employeeClient.findByDepartment(department.getId()))
        );

        return departments;
    }

}

