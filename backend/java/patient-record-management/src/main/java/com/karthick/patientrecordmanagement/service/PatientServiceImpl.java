package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.PatientDTO;
import com.karthick.patientrecordmanagement.entity.Patient;
import com.karthick.patientrecordmanagement.exception.ResourceNotFoundException;
import com.karthick.patientrecordmanagement.mapper.PatientMapper;
import com.karthick.patientrecordmanagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {

        Patient patient = PatientMapper.toEntity(patientDTO);

        Patient savedPatient = patientRepository.save(patient);

        return PatientMapper.toDTO(savedPatient);
    }

    @Override
    public PatientDTO getPatientById(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        return PatientMapper.toDTO(patient);
    }

    @Override
public Long getPatientCount() {
    return patientRepository.count();
}

    @Override
    public List<PatientDTO> getAllPatients() {

        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        patient.setName(patientDTO.getName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setWeight(patientDTO.getWeight());
        patient.setMobileNumber(patientDTO.getMobileNumber());

        Patient updatedPatient = patientRepository.save(patient);

        return PatientMapper.toDTO(updatedPatient);
    }

    @Override
    public void deletePatient(Long id) {

        patientRepository.deleteById(id);
    }

    @Override
public List<PatientDTO> searchPatients(String keyword) {

    return patientRepository
            .findByNameContainingIgnoreCase(keyword)
            .stream()
            .map(PatientMapper::toDTO)
            .toList();

}
    
}