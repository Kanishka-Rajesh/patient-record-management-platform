package com.karthick.patientrecordmanagement.repository;

import com.karthick.patientrecordmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByNameContainingIgnoreCase(String keyword);

}