package com.karthick.patientrecordmanagement.controller;

import com.karthick.patientrecordmanagement.dto.MedicationDTO;
import com.karthick.patientrecordmanagement.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
@RequiredArgsConstructor
public class MedicationController {

    private final MedicationService medicationService;

    @PostMapping
    public ResponseEntity<MedicationDTO> createMedication(
            @RequestBody MedicationDTO medicationDTO) {

        return ResponseEntity.ok(
                medicationService.createMedication(medicationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDTO> getMedication(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                medicationService.getMedicationById(id));
    }

    @GetMapping
    public ResponseEntity<List<MedicationDTO>> getAllMedications() {

        return ResponseEntity.ok(
                medicationService.getAllMedications());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationDTO> updateMedication(
            @PathVariable Long id,
            @RequestBody MedicationDTO medicationDTO) {

        return ResponseEntity.ok(
                medicationService.updateMedication(id, medicationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedication(
            @PathVariable Long id) {

        medicationService.deleteMedication(id);

        return ResponseEntity.ok("Medication deleted successfully");
    }
}