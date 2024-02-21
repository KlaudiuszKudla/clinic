package com.example.clinic.entity.office;

import com.example.clinic.entity.appointment.Appointment;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@ToString
@Table(name = "offices")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offices_id_seq")
    @SequenceGenerator(name = "offices_id_seq", sequenceName = "offices_id_seq", allocationSize = 1)
    private Long id;
    private int size;
    @OneToMany(mappedBy = "office")
    @JsonBackReference
    private List<Appointment> appointments;

    public void addAppointment(Appointment appointment){
        if (this.appointments == null){
            this.appointments = new ArrayList<>();
        }
        this.appointments.add(appointment);
        appointment.setOffice(this);
    }

}
