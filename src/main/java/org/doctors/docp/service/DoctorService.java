package org.doctors.docp.service;

import java.util.List;

import org.doctors.docp.entity.Doctor;
import org.doctors.docp.repository.DoctorRespotiory;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    
    private final DoctorRespotiory doctorRespotiory;

    public List<Doctor> getAll(){
        return doctorRespotiory.findAll();
    }

    public DoctorService(DoctorRespotiory doctorRespotiory){
        this.doctorRespotiory = doctorRespotiory;
    }

    public Doctor getByName(String name){
        return doctorRespotiory.findByFirstName(name).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor getById(Integer id){
        return doctorRespotiory.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor save(Doctor doctor){
        return doctorRespotiory.save(doctor);
    }

    public void deleteById(Integer id){
        doctorRespotiory.deleteById(id);
    }

}
