package com.example.clinic.entity.doctor;

import com.example.clinic.entity.appointment.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(generator = "doctors_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "doctors_id_seq", sequenceName = "doctors_id_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    @JsonIgnore
    @OneToMany(mappedBy = "doctor",
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Appointment> appointments;

    public void addAppointment(Appointment appointment){
        if (appointments == null){
            appointments = new HashSet<>();
        }
        appointments.add(appointment);
        appointment.setDoctor(this);
    }

}
