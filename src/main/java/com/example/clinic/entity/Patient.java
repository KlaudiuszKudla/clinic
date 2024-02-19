package com.example.clinic.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(generator = "patients_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "patients_id_seq", sequenceName = "patients_id_generator", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
    @OneToOne(mappedBy = "patient")
    private Appointment appointment;

}
