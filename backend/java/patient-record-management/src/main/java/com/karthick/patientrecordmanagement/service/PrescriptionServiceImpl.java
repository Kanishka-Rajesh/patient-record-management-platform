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

    @Override
public List<PrescriptionDTO> getByPatientId(Long patientId) {

    return prescriptionRepository
            .findByPatientId(patientId)
            .stream()
            .map(PrescriptionMapper::toDTO)
            .toList();
}

    @Override
public PrescriptionDTO createPrescription(PrescriptionDTO prescriptionDTO) {

    try {

        System.out.println("STEP 1");

        Prescription prescription = PrescriptionMapper.toEntity(prescriptionDTO);

        System.out.println("STEP 2");

        Patient patient = patientRepository.findById(prescriptionDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        System.out.println("STEP 3");

        prescription.setPatient(patient);

        System.out.println("STEP 4");

        Prescription saved = prescriptionRepository.save(prescription);

        System.out.println("STEP 5");

        PrescriptionDTO dto = PrescriptionMapper.toDTO(saved);

        System.out.println("STEP 6");

        return dto;

    } catch (Exception e) {

        e.printStackTrace();

        throw e;
    }
}
}