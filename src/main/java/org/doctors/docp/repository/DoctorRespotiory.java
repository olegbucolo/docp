package org.doctors.docp.repository;

import java.util.Optional;

import org.doctors.docp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRespotiory extends JpaRepository<Doctor, Integer> {
    
    public Optional<Doctor> findByFirstName(String name);

}
