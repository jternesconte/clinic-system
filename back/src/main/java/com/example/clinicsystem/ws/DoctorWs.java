package com.example.clinicsystem.ws;

import com.example.clinicsystem.controllers.DoctorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor")
public class DoctorWs {

    @Autowired
    DoctorController doctorController;
}
