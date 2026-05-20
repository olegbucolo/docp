package org.doctors.docp.controller;

import java.util.List;

import org.doctors.docp.entity.Department;
import org.doctors.docp.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {
    
    private final DepartmentRepository departmentService;

    public DepartmentRestController(DepartmentRepository departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> index(){
        return departmentService.findAll();
    }
}
