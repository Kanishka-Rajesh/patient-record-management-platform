package com.karthick.patientrecordmanagement.controller;

import com.karthick.patientrecordmanagement.dto.PrescriptionDTO;
import com.karthick.patientrecordmanagement.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

   

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> getPrescription(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                prescriptionService.getPrescriptionById(id));
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionDTO>> getAllPrescriptions() {

        return ResponseEntity.ok(
                prescriptionService.getAllPrescriptions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionDTO> updatePrescription(
            @PathVariable Long id,
            @RequestBody PrescriptionDTO prescriptionDTO) {

        return ResponseEntity.ok(
                prescriptionService.updatePrescription(id, prescriptionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrescription(
            @PathVariable Long id) {

        prescriptionService.deletePrescription(id);

        return ResponseEntity.ok("Prescription deleted successfully");
    }

    @GetMapping("/patient/{patientId}")
public ResponseEntity<List<PrescriptionDTO>> getByPatientId(
        @PathVariable Long patientId) {

    return ResponseEntity.ok(
            prescriptionService.getByPatientId(patientId));
}

@PostMapping
public ResponseEntity<PrescriptionDTO> createPrescription(
        @RequestBody PrescriptionDTO prescriptionDTO) {

    System.out.println("========== CONTROLLER HIT ==========");
    System.out.println(prescriptionDTO);

    return ResponseEntity.ok(
            prescriptionService.createPrescription(prescriptionDTO));
}
}