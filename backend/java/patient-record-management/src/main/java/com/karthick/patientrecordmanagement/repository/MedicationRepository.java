package com.karthick.patientrecordmanagement.repository;

import com.karthick.patientrecordmanagement.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}