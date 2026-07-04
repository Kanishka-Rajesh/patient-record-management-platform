package com.karthick.patientrecordmanagement.repository;

import com.karthick.patientrecordmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}