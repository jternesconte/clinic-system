package com.example.clinicsystem.ws;

import com.example.clinicsystem.controllers.PatientController;
import com.example.clinicsystem.models.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientWs {

    @Autowired
    private PatientController patientController;

    @GetMapping("/getAll")
    public @ResponseBody List<Patient> getAllPatients() {
        return patientController.getPatients();
    }

    @PostMapping("/create")
    public Patient newPatient(@RequestBody Patient patientDetails) {
        return patientController.createPatient(patientDetails);
    }

    @PutMapping("/edit/{id}")
    public Patient editPatient(@PathVariable int id, @RequestBody Patient patientDetails) {
        return patientController.alterPatient(id, patientDetails);
    }
}
