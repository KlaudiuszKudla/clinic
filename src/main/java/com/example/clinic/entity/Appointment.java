package com.example.clinic.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office office;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
    private boolean isFree;
    private boolean isFinished;
    private String note;
    private LocalTime admissionStartTime;
    private LocalTime admissionEndTime;
    private LocalDate admissionStartDate;
    private LocalDate admissionEndDate;
}
