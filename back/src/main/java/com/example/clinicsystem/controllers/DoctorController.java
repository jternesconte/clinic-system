package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.entities.Doctor;
import com.example.clinicsystem.models.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    public Doctor createDoctor(Doctor doctorDetails) {

        Doctor doctor = new Doctor(
                doctorDetails.getName(),
                doctorDetails.getPhone(),
                doctorDetails.getEmail()
        );

        return doctorRepository.save(doctor);
    }

    public Doctor alterDoctor(int id, Doctor doctorDetails) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);

        if(optionalDoctor.isPresent()) {
            Doctor currentDoctor = optionalDoctor.get();
            currentDoctor.setName(doctorDetails.getName() != null ? doctorDetails.getName() : currentDoctor.getName());
            currentDoctor.setPhone(doctorDetails.getPhone() != null ? doctorDetails.getPhone() : currentDoctor.getPhone());
            currentDoctor.setEmail(doctorDetails.getEmail() != null ? doctorDetails.getEmail() : currentDoctor.getEmail());

            return doctorRepository.save(currentDoctor);
        } else {
            throw new RuntimeException("Doctor not found with id " + id);
        }
    }
}
