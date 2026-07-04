package com.karthick.patientrecordmanagement.mapper;

import com.karthick.patientrecordmanagement.dto.PatientDTO;
import com.karthick.patientrecordmanagement.entity.Patient;

public class PatientMapper {

    public static PatientDTO toDTO(Patient patient) {

        if (patient == null)
            return null;

        PatientDTO dto = new PatientDTO();

        dto.setId(patient.getId());
        dto.setName(patient.getName());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setWeight(patient.getWeight());
        dto.setMobileNumber(patient.getMobileNumber());

        return dto;
    }

    public static Patient toEntity(PatientDTO dto) {

        if (dto == null)
            return null;

        Patient patient = new Patient();

        patient.setId(dto.getId());
        patient.setName(dto.getName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setWeight(dto.getWeight());
        patient.setMobileNumber(dto.getMobileNumber());

        return patient;
    }
}