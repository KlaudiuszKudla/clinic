package com.example.clinic.service;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.appointment.AppointmentCreatorDTO;
import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.office.Office;
import com.example.clinic.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public void addAppointment(Doctor doctor, Office office, AppointmentCreatorDTO appointmentCreatorDTO) {
        Appointment appointment = new Appointment();
//        appointment.setOffice(office);
//        appointment.setDoctor(doctor);
        appointment.setFree(true);
        appointment.setFinished(false);
        appointment.setAdmissionStartTime(appointmentCreatorDTO.getAdmissionStartTime());
        appointment.setAdmissionEndTime(appointmentCreatorDTO.getAdmissionEndTime());
        appointment.setAdmissionDate(appointmentCreatorDTO.getAdmissionDate());

        doctor.addAppointment(appointment);
        office.addAppointment(appointment);
        this.appointmentRepository.saveAndFlush(appointment);
    }
}
