package com.example.clinic.entity;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private Office office;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime admissionTime;
}
