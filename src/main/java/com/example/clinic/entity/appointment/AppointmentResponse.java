package com.example.clinic.entity.appointment;

import com.example.clinic.entity.doctor.DoctorResponse;
import com.example.clinic.entity.office.OfficeResponse;
import com.example.clinic.entity.patient.PatientResponse;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentResponse(
        PatientResponse patient,
        DoctorResponse doctor,
        OfficeResponse office,
        String note,
        LocalTime admissionStartTime,
        LocalTime admissionEndTime,
        LocalDate adnussionDate,
        boolean isFree,
        boolean isFinished
) {
}
