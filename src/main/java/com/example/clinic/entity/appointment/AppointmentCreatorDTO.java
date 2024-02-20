package com.example.clinic.entity.appointment;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class AppointmentCreatorDTO {

    private Long officeId;
    private Long doctorId;
    private LocalTime admissionStartTime;
    private LocalTime admissionEndTime;
    private LocalDate admissionDate;

}
