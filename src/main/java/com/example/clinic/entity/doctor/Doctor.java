package com.example.clinic.entity.doctor;

import com.example.clinic.entity.appointment.Appointment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
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
    @JsonBackReference
    @OneToMany(mappedBy = "doctor",
                fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                            CascadeType.DETACH, CascadeType.REFRESH})
    private List<Appointment> appointments;

    public void addAppointment(Appointment appointment){
        if (appointments == null){
            appointments = new ArrayList<>();
        }
        appointments.add(appointment);
        appointment.setDoctor(this);
    }

}
