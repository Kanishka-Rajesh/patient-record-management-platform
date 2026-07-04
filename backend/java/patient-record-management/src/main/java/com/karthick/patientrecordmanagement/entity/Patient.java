package com.karthick.patientrecordmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Patient extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private LocalDate dateOfBirth;

    private Double weight;

    @Column(nullable = false)
    private String mobileNumber;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Prescription> prescriptions = new ArrayList<>();
}