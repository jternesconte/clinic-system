package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.entities.Patient;
import com.example.clinicsystem.models.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    public Patient createPatient(Patient patientDetails) {

        Patient patient = new Patient(
                patientDetails.getName(),
                patientDetails.getBirthDate(),
                patientDetails.getPhone(),
                patientDetails.getEmail(),
                patientDetails.getAddress()
        );

        return patientRepository.save(patient);
    }

    public Patient alterPatient(int id, Patient patientDetails) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if(optionalPatient.isPresent()) {
            Patient currentPatient = optionalPatient.get();
            currentPatient.setName(patientDetails.getName() != null ? patientDetails.getName() : currentPatient.getName());
            currentPatient.setBirthDate(patientDetails.getBirthDate() != null ? patientDetails.getBirthDate() : currentPatient.getBirthDate());
            currentPatient.setPhone(patientDetails.getPhone() != null ? patientDetails.getPhone() : currentPatient.getPhone());
            currentPatient.setEmail(patientDetails.getEmail() != null ? patientDetails.getEmail() : currentPatient.getEmail());
            currentPatient.setAddress(patientDetails.getAddress() != null ? patientDetails.getAddress() : currentPatient.getAddress());

            return patientRepository.save(currentPatient);
        } else {
            throw new RuntimeException("Patient not found with id " + id);
        }
    }
}
