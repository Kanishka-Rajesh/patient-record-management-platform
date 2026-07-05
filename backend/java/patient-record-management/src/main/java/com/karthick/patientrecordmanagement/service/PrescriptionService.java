package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.PrescriptionDTO;

import java.util.List;

public interface PrescriptionService {

    PrescriptionDTO createPrescription(PrescriptionDTO prescriptionDTO);

    PrescriptionDTO getPrescriptionById(Long id);

    List<PrescriptionDTO> getAllPrescriptions();

    PrescriptionDTO updatePrescription(Long id, PrescriptionDTO prescriptionDTO);

    void deletePrescription(Long id);

    List<PrescriptionDTO> getByPatientId(Long patientId);
    
}