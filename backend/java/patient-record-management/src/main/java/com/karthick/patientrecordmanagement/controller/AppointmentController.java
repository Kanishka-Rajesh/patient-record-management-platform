package com.karthick.patientrecordmanagement.controller;

import com.karthick.patientrecordmanagement.dto.AppointmentDTO;
import com.karthick.patientrecordmanagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(
            @RequestBody AppointmentDTO appointmentDTO) {

        return ResponseEntity.ok(
                appointmentService.createAppointment(appointmentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointment(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {

        return ResponseEntity.ok(
                appointmentService.getAllAppointments());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(
            @PathVariable Long id,
            @RequestBody AppointmentDTO appointmentDTO) {

        return ResponseEntity.ok(
                appointmentService.updateAppointment(id, appointmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(
            @PathVariable Long id) {

        appointmentService.deleteAppointment(id);

        return ResponseEntity.ok("Appointment deleted successfully");
    }
}