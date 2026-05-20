package org.doctors.docp.repository;

import java.util.Optional;

import org.doctors.docp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

    public Optional<Department> findByName(String name);
}
