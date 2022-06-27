package com.example.hasscriptmongo.controller;
import com.example.hasscriptmongo.dto.AppointmentDto;
import com.example.hasscriptmongo.model.Appointment;
import com.example.hasscriptmongo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Validated
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    public Appointment addAppointment(@Valid@RequestBody AppointmentDto appointmentDto){
        return  appointmentService.addAppointment(appointmentDto);
    }
    @GetMapping("/{userId}")
    public List<Appointment> findByUserId(@PathVariable("userId") String userId){
        return appointmentService.findByUserId(userId);
    }
    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable("id") String id) {
        return appointmentService.deleteById(id);
    }
    @PatchMapping("/patch/{id}/{description}")
    public Boolean patchById(@PathVariable("id") String id, @PathVariable("description")String description){
        return appointmentService.patchById(id,description);
    }

}
