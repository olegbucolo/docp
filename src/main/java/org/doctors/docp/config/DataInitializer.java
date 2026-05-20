package org.doctors.docp.config;

import java.math.BigDecimal;
import java.util.List;

import org.doctors.docp.entity.Department;
import org.doctors.docp.entity.Doctor;
import org.doctors.docp.repository.DepartmentRepository;
import org.doctors.docp.repository.DoctorRespotiory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final DoctorRespotiory doctorRepository;

    public DataInitializer(DepartmentRepository departmentRepository, DoctorRespotiory doctorRepository) {
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void run(String... args) {
        if (departmentRepository.count() == 0) {
            List<Department> departments = List.of(
                    createDepartment("Cardiology",
                            "Deals with disorders of the heart and blood vessels."),
                    createDepartment("Dermatology",
                            "Focuses on skin, hair, and nail conditions."),
                    createDepartment("Neurology",
                            "Handles disorders of the nervous system including brain and spinal cord."),
                    createDepartment("Orthopedics",
                            "Specializes in bones, joints, ligaments, and muscles."),
                    createDepartment("Pediatrics",
                            "Medical care for infants, children, and adolescents."),
                    createDepartment("Ophthalmology",
                            "Focuses on eye disorders and vision care."),
                    createDepartment("Gastroenterology",
                            "Deals with digestive system and related disorders."),
                    createDepartment("Psychiatry",
                            "Focuses on mental health, emotional and behavioral disorders."));
            departmentRepository.saveAll(departments);
        }

        if (doctorRepository.count() == 0) {
            List<Doctor> doctors = List.of(
                    createDoctor("Keanu", "Reeves", "keanu.reeves@docp.com", new BigDecimal("9.5")),
                    createDoctor("John", "Smith", "john.smith@docp.com", new BigDecimal("8.2")),
                    createDoctor("Emma", "Johnson", "emma.johnson@docp.com", new BigDecimal("9.1")),
                    createDoctor("Luca", "Bianchi", "luca.bianchi@docp.com", new BigDecimal("7.8")),
                    createDoctor("Sofia", "Rossi", "sofia.rossi@docp.com", new BigDecimal("8.9")),
                    createDoctor("Marco", "Ferrari", "marco.ferrari@docp.com", new BigDecimal("8.0")),
                    createDoctor("Giulia", "Conti", "giulia.conti@docp.com", new BigDecimal("9.3")),
                    createDoctor("David", "Brown", "david.brown@docp.com", new BigDecimal("7.5")),
                    createDoctor("Anna", "Verdi", "anna.verdi@docp.com", new BigDecimal("8.7")));
            doctorRepository.saveAll(doctors);
        }

    }

    private Department createDepartment(String name, String description) {
        Department d = new Department();
        d.setName(name);
        d.setDescription(description);
        return d;
    }

    private Doctor createDoctor(String firstName, String lastName, String email, BigDecimal rating) {
        Doctor d = new Doctor();
        d.setFirstName(firstName);
        d.setLastName(lastName);
        d.setEmail(email);
        d.setRating(rating);
        return d;
    }

}
