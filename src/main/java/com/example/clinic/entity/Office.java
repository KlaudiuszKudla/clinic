package com.example.clinic.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offices_id_seq")
    @SequenceGenerator(name = "offices_id_seq", sequenceName = "offices_id_generator", allocationSize = 1)
    private Long id;
    private int size;
    @OneToOne(mappedBy = "office")
    private Appointment appointment;

}
