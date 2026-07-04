package com.karthick.patientrecordmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDTO {

    private String symptoms;
    private String findings;
    private String diagnosis;
    private List<MedicationDTO> medications;
    private Long patientId;
}