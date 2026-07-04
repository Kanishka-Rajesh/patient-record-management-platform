package com.karthick.patientrecordmanagement.mapper;

import com.karthick.patientrecordmanagement.dto.MedicationDTO;
import com.karthick.patientrecordmanagement.dto.PrescriptionDTO;
import com.karthick.patientrecordmanagement.entity.Medication;
import com.karthick.patientrecordmanagement.entity.Prescription;

import java.util.List;
import java.util.stream.Collectors;

public class PrescriptionMapper {

    public static PrescriptionDTO toDTO(Prescription prescription) {

        if (prescription == null)
            return null;

        PrescriptionDTO dto = new PrescriptionDTO();

        dto.setSymptoms(prescription.getSymptoms());
        dto.setFindings(prescription.getFindings());
        dto.setDiagnosis(prescription.getDiagnosis());

        List<MedicationDTO> medicationDTOs =
                prescription.getMedications()
                        .stream()
                        .map(MedicationMapper::toDTO)
                        .collect(Collectors.toList());

        dto.setMedications(medicationDTOs);

        return dto;
    }

    public static Prescription toEntity(PrescriptionDTO dto) {

        if (dto == null)
            return null;

        Prescription prescription = new Prescription();

        prescription.setSymptoms(dto.getSymptoms());
        prescription.setFindings(dto.getFindings());
        prescription.setDiagnosis(dto.getDiagnosis());

        List<Medication> medications =
                dto.getMedications()
                        .stream()
                        .map(MedicationMapper::toEntity)
                        .collect(Collectors.toList());

        prescription.setMedications(medications);

        return prescription;
    }
}