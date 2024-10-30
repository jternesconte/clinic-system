package com.example.clinicsystem.ws;

import com.example.clinicsystem.controllers.SchedulingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scheduling")
public class SchedulingWs {

    @Autowired
    SchedulingController schedulingController;
}
