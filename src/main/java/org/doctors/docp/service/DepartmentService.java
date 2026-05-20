package org.doctors.docp.service;

import java.util.List;

import org.doctors.docp.entity.Department;
import org.doctors.docp.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Department getById(Integer id){
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department getByName(String name){
        return departmentRepository.findByName(name).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    public void deleteById(Integer id){
        departmentRepository.deleteById(id);
    }

}
