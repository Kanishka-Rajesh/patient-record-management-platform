package com.karthick.patientrecordmanagement.controller;

import com.karthick.patientrecordmanagement.dto.PatientDTO;
import com.karthick.patientrecordmanagement.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(
            @Valid @RequestBody PatientDTO patientDTO) {

        return ResponseEntity.ok(
                patientService.createPatient(patientDTO));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getPatientCount() {

        return ResponseEntity.ok(
                patientService.getPatientCount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                patientService.getPatientById(id));
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {

        return ResponseEntity.ok(
                patientService.getAllPatients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientDTO patientDTO) {

        return ResponseEntity.ok(
                patientService.updatePatient(id, patientDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(
            @PathVariable Long id) {

        patientService.deletePatient(id);

        return ResponseEntity.ok("Patient deleted successfully");
    }

   
}