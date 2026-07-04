package com.karthick.patientrecordmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardResponse {

    private long totalPatients;

    private long totalAppointments;

    private long totalPrescriptions;
}