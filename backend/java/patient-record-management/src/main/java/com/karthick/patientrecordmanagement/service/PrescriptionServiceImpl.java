package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.PrescriptionDTO;
import com.karthick.patientrecordmanagement.entity.Patient;
import com.karthick.patientrecordmanagement.entity.Prescription;
import com.karthick.patientrecordmanagement.exception.ResourceNotFoundException;
import com.karthick.patientrecordmanagement.mapper.PrescriptionMapper;
import com.karthick.patientrecordmanagement.repository.PatientRepository;
import com.karthick.patientrecordmanagement.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;

    @Override
    public PrescriptionDTO createPrescription(PrescriptionDTO prescriptionDTO) {

        Prescription prescription = PrescriptionMapper.toEntity(prescriptionDTO);

Patient patient = patientRepository.findById(prescriptionDTO.getPatientId())
        .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

prescription.setPatient(patient);

Prescription saved = prescriptionRepository.save(prescription);

return PrescriptionMapper.toDTO(saved);
    }

    @Override
    public PrescriptionDTO getPrescriptionById(Long id) {

        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found"));

        return PrescriptionMapper.toDTO(prescription);
    }

    @Override
    public List<PrescriptionDTO> getAllPrescriptions() {

        return prescriptionRepository.findAll()
                .stream()
                .map(PrescriptionMapper::toDTO)
                .toList();
    }

    @Override
    public PrescriptionDTO updatePrescription(Long id, PrescriptionDTO prescriptionDTO) {

        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prescription not found"));

        prescription.setSymptoms(prescriptionDTO.getSymptoms());
        prescription.setFindings(prescriptionDTO.getFindings());
        prescription.setDiagnosis(prescriptionDTO.getDiagnosis());

        Prescription updated = prescriptionRepository.save(prescription);

        return PrescriptionMapper.toDTO(updated);
    }

    @Override
    public void deletePrescription(Long id) {

        prescriptionRepository.deleteById(id);
    }
}