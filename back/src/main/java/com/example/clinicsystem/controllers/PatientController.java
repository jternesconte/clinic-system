package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
}
