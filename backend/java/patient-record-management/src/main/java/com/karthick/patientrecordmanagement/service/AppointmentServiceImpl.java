package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.AppointmentDTO;
import com.karthick.patientrecordmanagement.entity.Appointment;
import com.karthick.patientrecordmanagement.exception.ResourceNotFoundException;
import com.karthick.patientrecordmanagement.mapper.AppointmentMapper;
import com.karthick.patientrecordmanagement.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.karthick.patientrecordmanagement.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {

        Appointment appointment = AppointmentMapper.toEntity(appointmentDTO);

        Appointment savedAppointment = appointmentRepository.save(appointment);

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