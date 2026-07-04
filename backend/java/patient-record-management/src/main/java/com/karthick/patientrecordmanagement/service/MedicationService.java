package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.MedicationDTO;

import java.util.List;

public interface MedicationService {

    MedicationDTO createMedication(MedicationDTO medicationDTO);

    MedicationDTO getMedicationById(Long id);

    List<MedicationDTO> getAllMedications();

    MedicationDTO updateMedication(Long id, MedicationDTO medicationDTO);

    void deleteMedication(Long id);
}