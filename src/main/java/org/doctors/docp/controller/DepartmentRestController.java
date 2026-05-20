package org.doctors.docp.controller;

import java.util.List;

import org.doctors.docp.entity.Department;
import org.doctors.docp.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {
    
    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> index(){
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Department show(@PathVariable Integer id){
        return departmentService.getById(id);
    }
}
