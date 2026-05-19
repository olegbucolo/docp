package org.doctors.docp.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 250, message = "The name of the department has to contain max 250 characters")
    @Column(nullable = false, unique = true, length = 250)
    private String name;

    @NotBlank
    @Size(max = 1000, message = "The description of the department has to contain max 1000 characters")
    @Column(nullable = false, length = 1000)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private Set<DepartmentDoctor> doctorLinks = new HashSet<>();

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // OVERRIDES

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Department))
            return false;
        Department department = (Department) o;
        return id != null && id.equals(department.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\''
                + '}';
    }

}
