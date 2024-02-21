package com.example.clinic.entity.patient;

public record PatientResponse(
        String firstName,
        String lastName,
        String pesel
) {
}
