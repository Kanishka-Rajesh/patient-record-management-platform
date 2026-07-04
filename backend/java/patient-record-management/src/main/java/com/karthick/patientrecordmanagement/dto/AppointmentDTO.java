package com.karthick.patientrecordmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private Long patientId;
    private String name;
    private String mobileNumber;
    private LocalDate dateOfBirth;
    private Double weight;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String appointmentType;
    private String token;
}