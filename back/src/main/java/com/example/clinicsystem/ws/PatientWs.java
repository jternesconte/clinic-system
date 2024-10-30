package com.example.clinicsystem.ws;

import com.example.clinicsystem.controllers.PatientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
public class PatientWs {

    @Autowired
    private PatientController patientController;
}
