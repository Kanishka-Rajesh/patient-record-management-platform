package com.karthick.patientrecordmanagement.mapper;

import com.karthick.patientrecordmanagement.dto.MedicationDTO;
import com.karthick.patientrecordmanagement.entity.Medication;

public class MedicationMapper {

    public static MedicationDTO toDTO(Medication medication) {

        if (medication == null)
            return null;

        MedicationDTO dto = new MedicationDTO();

        dto.setMedicationName(medication.getMedicationName());
        dto.setDosage(medication.getDosage());
        dto.setFrequency(medication.getFrequency());
        dto.setDuration(medication.getDuration());

        return dto;
    }

    public static Medication toEntity(MedicationDTO dto) {

        if (dto == null)
            return null;

        Medication medication = new Medication();

        medication.setMedicationName(dto.getMedicationName());
        medication.setDosage(dto.getDosage());
        medication.setFrequency(dto.getFrequency());
        medication.setDuration(dto.getDuration());

        return medication;
    }
}