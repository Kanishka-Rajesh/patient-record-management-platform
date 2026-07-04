package com.karthick.patientrecordmanagement.repository;

import com.karthick.patientrecordmanagement.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    

    

}