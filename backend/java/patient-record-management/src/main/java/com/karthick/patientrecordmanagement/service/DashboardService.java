package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.response.DashboardResponse;
import com.karthick.patientrecordmanagement.repository.AppointmentRepository;
import com.karthick.patientrecordmanagement.repository.PatientRepository;
import com.karthick.patientrecordmanagement.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final PrescriptionRepository prescriptionRepository;

    public DashboardResponse getDashboardStats() {

        long totalPatients = patientRepository.count();

        long totalAppointments = appointmentRepository.count();

        long totalPrescriptions = prescriptionRepository.count();

        return new DashboardResponse(
                totalPatients,
                totalAppointments,
                totalPrescriptions
        );
    }
}