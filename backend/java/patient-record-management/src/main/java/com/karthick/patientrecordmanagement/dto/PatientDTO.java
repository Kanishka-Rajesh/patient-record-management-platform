package com.karthick.patientrecordmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Long id;

    @NotBlank(message = "Patient name is required")
    private String name;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be greater than 0")
    private Double weight;

    @NotBlank(message = "Mobile number is required")
    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Invalid Indian mobile number"
    )
    private String mobileNumber;
}