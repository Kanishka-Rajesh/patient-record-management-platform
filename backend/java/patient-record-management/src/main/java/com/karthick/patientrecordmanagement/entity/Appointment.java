package com.karthick.patientrecordmanagement.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Appointment extends BaseEntity {

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