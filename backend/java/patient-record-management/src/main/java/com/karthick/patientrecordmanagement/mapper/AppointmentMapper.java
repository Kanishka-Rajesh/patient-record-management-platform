package com.karthick.patientrecordmanagement.mapper;

import com.karthick.patientrecordmanagement.dto.AppointmentDTO;
import com.karthick.patientrecordmanagement.entity.Appointment;

public class AppointmentMapper {

    public static AppointmentDTO toDTO(Appointment appointment) {

        if (appointment == null)
            return null;

        AppointmentDTO dto = new AppointmentDTO();

        dto.setPatientId(appointment.getPatientId());
        dto.setName(appointment.getName());
        dto.setMobileNumber(appointment.getMobileNumber());
        dto.setDateOfBirth(appointment.getDateOfBirth());
        dto.setWeight(appointment.getWeight());
        dto.setAppointmentDate(appointment.getAppointmentDate());
        dto.setAppointmentTime(appointment.getAppointmentTime());
        dto.setAppointmentType(appointment.getAppointmentType());
        dto.setToken(appointment.getToken());

        return dto;
    }

    public static Appointment toEntity(AppointmentDTO dto) {

        if (dto == null)
            return null;

        Appointment appointment = new Appointment();

        appointment.setPatientId(dto.getPatientId());
        appointment.setName(dto.getName());
        appointment.setMobileNumber(dto.getMobileNumber());
        appointment.setDateOfBirth(dto.getDateOfBirth());
        appointment.setWeight(dto.getWeight());
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setAppointmentType(dto.getAppointmentType());
        appointment.setToken(dto.getToken());

        return appointment;
    }

}