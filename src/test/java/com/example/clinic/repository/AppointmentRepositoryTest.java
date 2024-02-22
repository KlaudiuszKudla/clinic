package com.example.clinic.repository;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.doctor.Doctor;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void AppointmentRepository_findAppointmentsByIsFreeAndDoctorId_ReturnAppointment(){
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        Doctor managedDoctor = entityManager.merge(doctor);
        Appointment appointment = new Appointment();
        appointment.setFree(true);
        appointment.setDoctor(managedDoctor);

        appointmentRepository.saveAndFlush(appointment);
        List<Appointment> actual = appointmentRepository.findAppointmentsByIsFreeAndDoctorId(1L);
        assertFalse(actual.isEmpty());

    }
    @Test
    public void AppointmentRepository_findAppointmentsByIsFreeAndDoctorId_ReturnNull(){
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        Doctor managedDoctor = entityManager.merge(doctor);
        Appointment appointment = new Appointment();
        appointment.setFree(false);
        appointment.setDoctor(managedDoctor);

        appointmentRepository.saveAndFlush(appointment);
        List<Appointment> actual = appointmentRepository.findAppointmentsByIsFreeAndDoctorId(1L);
        assertTrue(actual.isEmpty());

    }

    @Test
    public void AppointmentRepository_findAppointmentsByIsFreeAndDoctorId_ReturnNulll(){
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        Doctor managedDoctor = entityManager.merge(doctor);
        Appointment appointment = new Appointment();
        appointment.setFree(false);
        appointment.setDoctor(managedDoctor);

        appointmentRepository.saveAndFlush(appointment);
        List<Appointment> actual = appointmentRepository.findAppointmentsByIsFreeAndDoctorId(2L);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void AppointmentRepository_findAppointmentsByIsFreeAndDoctorId_ReturnNullll(){
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        Doctor managedDoctor = entityManager.merge(doctor);
        Appointment appointment = new Appointment();
        appointment.setFree(true);
        appointment.setDoctor(managedDoctor);

        appointmentRepository.saveAndFlush(appointment);
        List<Appointment> actual = appointmentRepository.findAppointmentsByIsFreeAndDoctorId(2L);
        assertTrue(actual.isEmpty());
    }
}
