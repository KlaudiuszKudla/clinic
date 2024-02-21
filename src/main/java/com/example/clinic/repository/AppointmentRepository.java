package com.example.clinic.repository;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAppointmentByDoctor(Doctor doctor);
}
