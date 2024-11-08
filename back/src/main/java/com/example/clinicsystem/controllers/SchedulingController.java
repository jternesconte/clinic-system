package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.entities.Doctor;
import com.example.clinicsystem.models.entities.Patient;
import com.example.clinicsystem.models.entities.Scheduling;
import com.example.clinicsystem.models.repositories.DoctorRepository;
import com.example.clinicsystem.models.repositories.PatientRepository;
import com.example.clinicsystem.models.repositories.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class SchedulingController {

    @Autowired
    SchedulingRepository schedulingRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public List<Scheduling> getSchedulings() {
        return (List<Scheduling>) schedulingRepository.findAll();
    }

    public Scheduling createScheduling(int idPatient, int idDoctor, Scheduling schedulingDetails) {
        Patient selectedPatient = patientRepository.findById(idPatient)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor selectedDoctor = doctorRepository.findById(idDoctor)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Scheduling scheduling = new Scheduling(
                selectedPatient,
                selectedDoctor,
                schedulingDetails.getSchedulingDate(),
                schedulingDetails.getSchedulingTime(),
                schedulingDetails.getStatus(),
                schedulingDetails.getNotes()
        );

        return schedulingRepository.save(scheduling);
    }

    public Scheduling alterScheduling(int id, Scheduling schedulingDetails) {
        Optional<Scheduling> optionalScheduling = schedulingRepository.findById(id);

        if(optionalScheduling.isPresent()) {
            Scheduling currentScheduling = optionalScheduling.get();
            currentScheduling.setSchedulingDate(schedulingDetails.getSchedulingDate() != null ? schedulingDetails.getSchedulingDate() : currentScheduling.getSchedulingDate());
            currentScheduling.setSchedulingTime(schedulingDetails.getSchedulingTime() != null ? schedulingDetails.getSchedulingTime() : currentScheduling.getSchedulingTime());
            currentScheduling.setStatus(schedulingDetails.getStatus() != null ? schedulingDetails.getStatus() : currentScheduling.getStatus());
            currentScheduling.setNotes(schedulingDetails.getNotes() != null ? schedulingDetails.getNotes() : currentScheduling.getNotes());

            return schedulingRepository.save(currentScheduling);
        } else {
            throw new RuntimeException("Scheduling not found with id: " + id);
        }
    }
}
