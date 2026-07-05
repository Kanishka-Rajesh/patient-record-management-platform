package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.AppointmentDTO;
import com.karthick.patientrecordmanagement.entity.Appointment;
import com.karthick.patientrecordmanagement.entity.Patient;
import com.karthick.patientrecordmanagement.exception.ResourceNotFoundException;
import com.karthick.patientrecordmanagement.mapper.AppointmentMapper;
import com.karthick.patientrecordmanagement.repository.AppointmentRepository;
import com.karthick.patientrecordmanagement.repository.PatientRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {

        Patient patient = patientRepository.findById(
        appointmentDTO.getPatientId())
        .orElseThrow(() ->
                new ResourceNotFoundException("Patient not found"));

Appointment appointment = AppointmentMapper.toEntity(appointmentDTO);

// Copy patient details automatically
appointment.setName(patient.getName());
appointment.setMobileNumber(patient.getMobileNumber());
appointment.setDateOfBirth(patient.getDateOfBirth());
appointment.setWeight(patient.getWeight());

Appointment savedAppointment =
        appointmentRepository.save(appointment);

return AppointmentMapper.toDTO(savedAppointment);

        
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        return AppointmentMapper.toDTO(appointment);
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {

        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentMapper::toDTO)
                .toList();
    }

    @Override
    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));

        appointment.setPatientId(appointmentDTO.getPatientId());
        appointment.setName(appointmentDTO.getName());
        appointment.setMobileNumber(appointmentDTO.getMobileNumber());
        appointment.setDateOfBirth(appointmentDTO.getDateOfBirth());
        appointment.setWeight(appointmentDTO.getWeight());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
        appointment.setAppointmentType(appointmentDTO.getAppointmentType());
        appointment.setToken(appointmentDTO.getToken());

        Appointment updatedAppointment = appointmentRepository.save(appointment);

        return AppointmentMapper.toDTO(updatedAppointment);
    }

    @Override
    public void deleteAppointment(Long id) {

        appointmentRepository.deleteById(id);
    }
}