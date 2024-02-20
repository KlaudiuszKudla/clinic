package com.example.clinic.entity.office;

import com.example.clinic.entity.appointment.Appointment;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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
    private Set<Appointment> appointments;

    public void addAppointment(Appointment appointment){
        if (this.appointments == null){
            this.appointments = new HashSet<>();
        }
        this.appointments.add(appointment);
        appointment.setOffice(this);
    }

}
