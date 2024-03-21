package com.yvolabs.departmentservice.repository;

import com.yvolabs.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple class repository for demo only
 */
@Repository
public class DepartmentRepository {
    List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll(){
        return departments;
    }
}
