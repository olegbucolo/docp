package org.doctors.docp.controller;

import java.util.List;

import org.doctors.docp.entity.Doctor;
import org.doctors.docp.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorRestController {
    
    private final DoctorService doctorService;

    public DoctorRestController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> index(){
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Doctor show(@PathVariable Integer id){
        return doctorService.getById(id);
    }

    
}
