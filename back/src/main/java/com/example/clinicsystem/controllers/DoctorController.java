package com.example.clinicsystem.controllers;

import com.example.clinicsystem.models.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DoctorController {

    @Autowired
    DoctorRepository doctorRepository;
}