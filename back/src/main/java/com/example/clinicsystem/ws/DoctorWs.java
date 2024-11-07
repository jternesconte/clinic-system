package com.example.clinicsystem.ws;

import com.example.clinicsystem.controllers.DoctorController;
import com.example.clinicsystem.models.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorWs {

    @Autowired
    DoctorController doctorController;

    @GetMapping("/getAll")
    public @ResponseBody List<Doctor> getAllDoctors() {
        return doctorController.getDoctors();
    }

    @PostMapping("/create")
    public Doctor newDoctor(@RequestBody Doctor doctorDetails) {
        return doctorController.createDoctor(doctorDetails);
    }

    @PutMapping("/edit/{id}")
        public Doctor editDoctor(@PathVariable int id, @RequestBody Doctor doctorDetails) {
        return doctorController.alterDoctor(id, doctorDetails);
    }
}
