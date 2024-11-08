package com.example.clinicsystem.ws;

import com.example.clinicsystem.controllers.SchedulingController;
import com.example.clinicsystem.models.entities.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduling")
public class SchedulingWs {

    @Autowired
    SchedulingController schedulingController;

    @GetMapping("/getAll")
    public @ResponseBody List<Scheduling> getAllSchedulings() {
        return schedulingController.getSchedulings();
    }

    @PostMapping("/create/{idPatient}/{idDoctor}")
    public Scheduling newScheduling(@PathVariable int idPatient, @PathVariable int idDoctor, @RequestBody Scheduling schedulingDetails) {
        return schedulingController.createScheduling(idPatient, idDoctor, schedulingDetails);
    }

    @PutMapping("edit/{id}")
    public Scheduling editScheduling(@PathVariable int id, @RequestBody Scheduling schedulingDetails) {
        return schedulingController.alterScheduling(id, schedulingDetails);
    }
}
