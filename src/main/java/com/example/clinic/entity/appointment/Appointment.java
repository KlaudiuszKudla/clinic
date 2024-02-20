package com.example.clinic.entity.appointment;

import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.office.Office;
import com.example.clinic.entity.patient.Patient;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(generator = "appointments_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "appointments_id_seq", sequenceName = "appointments_id_seq", allocationSize = 1)
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
    private LocalDate admissionDate;
}
