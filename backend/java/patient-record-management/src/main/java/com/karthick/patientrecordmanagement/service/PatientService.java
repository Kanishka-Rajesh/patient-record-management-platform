package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientDTO createPatient(PatientDTO patientDTO);

    PatientDTO getPatientById(Long id);

    List<PatientDTO> getAllPatients();

    PatientDTO updatePatient(Long id, PatientDTO patientDTO);

    void deletePatient(Long id);

    Long getPatientCount();

    List<PatientDTO> searchPatients(String keyword);

    
}