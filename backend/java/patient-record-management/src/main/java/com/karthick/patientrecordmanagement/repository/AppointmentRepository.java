package com.karthick.patientrecordmanagement.repository;

import com.karthick.patientrecordmanagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}