package com.example.clinicsystem.models.repositories;

import com.example.clinicsystem.models.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
