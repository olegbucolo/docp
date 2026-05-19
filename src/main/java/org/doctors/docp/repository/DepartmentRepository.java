package org.doctors.docp.repository;

import org.doctors.docp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
}
