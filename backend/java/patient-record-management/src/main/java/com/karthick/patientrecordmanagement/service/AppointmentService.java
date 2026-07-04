package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);

    AppointmentDTO getAppointmentById(Long id);

    List<AppointmentDTO> getAllAppointments();

    AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO);

    void deleteAppointment(Long id);

}