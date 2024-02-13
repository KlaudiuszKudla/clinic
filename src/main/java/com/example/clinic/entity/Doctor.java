package com.example.clinic.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(generator = "doctors_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "doctors_id_seq", sequenceName = "doctors_id_seq", allocationSize = 1)
    private int id;
    private String firstName;
    private String lastName;
    private String specialization;
    private Office office;
    private Appointment appointment;

}
