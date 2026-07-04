package com.karthick.patientrecordmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Medication extends BaseEntity {

    private String medicationName;

    private Integer dosage;

    private Integer frequency;

    private Integer duration;
}