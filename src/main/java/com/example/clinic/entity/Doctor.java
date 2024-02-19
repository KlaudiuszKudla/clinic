package com.example.clinic.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import java.util.Set;


@Entity
@Data
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(generator = "doctors_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "doctors_id_seq", sequenceName = "doctors_id_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    @OneToMany(mappedBy = "doctor",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Appointment> appointments;

}
