package com.karthick.patientrecordmanagement.service;

import com.karthick.patientrecordmanagement.dto.MedicationDTO;
import com.karthick.patientrecordmanagement.entity.Medication;
import com.karthick.patientrecordmanagement.mapper.MedicationMapper;
import com.karthick.patientrecordmanagement.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.karthick.patientrecordmanagement.exception.ResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    @Override
    public MedicationDTO createMedication(MedicationDTO medicationDTO) {

        Medication medication = MedicationMapper.toEntity(medicationDTO);

        Medication savedMedication = medicationRepository.save(medication);

        return MedicationMapper.toDTO(savedMedication);
    }

    @Override
    public MedicationDTO getMedicationById(Long id) {

        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medication not found"));

        return MedicationMapper.toDTO(medication);
    }

    @Override
    public List<MedicationDTO> getAllMedications() {

        return medicationRepository.findAll()
                .stream()
                .map(MedicationMapper::toDTO)
                .toList();
    }

    @Override
    public MedicationDTO updateMedication(Long id, MedicationDTO medicationDTO) {

        Medication medication = medicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medication not found"));

        medication.setMedicationName(medicationDTO.getMedicationName());
        medication.setDosage(medicationDTO.getDosage());
        medication.setFrequency(medicationDTO.getFrequency());
        medication.setDuration(medicationDTO.getDuration());

        Medication updatedMedication = medicationRepository.save(medication);

        return MedicationMapper.toDTO(updatedMedication);
    }

    @Override
    public void deleteMedication(Long id) {

        medicationRepository.deleteById(id);
    }
}