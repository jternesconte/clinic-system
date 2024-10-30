package com.example.clinicsystem.models.repositories;

import com.example.clinicsystem.models.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
