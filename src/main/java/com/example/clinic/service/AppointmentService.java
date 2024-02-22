package com.example.clinic.service;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.appointment.AppointmentCreatorDTO;
import com.example.clinic.entity.appointment.AppointmentResponse;
import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.office.Office;
import com.example.clinic.exception.AppointmentDontExistByIsFreeWithDoctorId;
import com.example.clinic.exception.AppointmentDontExistException;
import com.example.clinic.mapper.AppointmentMapper;
import com.example.clinic.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public void addAppointment(Doctor doctor, Office office, AppointmentCreatorDTO appointmentCreatorDTO) {
        Appointment appointment = new Appointment();
        appointment.setOffice(office);
        appointment.setDoctor(doctor);
        appointment.setFree(true);
        appointment.setFinished(false);
        appointment.setAdmissionStartTime(appointmentCreatorDTO.getAdmissionStartTime());
        appointment.setAdmissionEndTime(appointmentCreatorDTO.getAdmissionEndTime());
        appointment.setAdmissionDate(appointmentCreatorDTO.getAdmissionDate());

        doctor.addAppointment(appointment);
        office.addAppointment(appointment);
        this.appointmentRepository.saveAndFlush(appointment);
    }

    public List<AppointmentResponse> getAppointmentsByDoctorId(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByDoctorId(doctorId);
        if(appointments.isEmpty()){
            throw new AppointmentDontExistByIsFreeWithDoctorId("Free appointment dont exist with doctor");
        }
        List<AppointmentResponse> appointmentResponse = mapListAppointmentsToAppointmentsResponse(appointments);
        return appointmentResponse;
    }

    public List<AppointmentResponse> getAppointmentsByIsFreeAndDoctorId(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByIsFreeAndDoctorId(doctorId);
        if(appointments.isEmpty()){
            throw new AppointmentDontExistByIsFreeWithDoctorId("Free appointment dont exist with doctor");
        }
        List<AppointmentResponse> appointmentResponse = mapListAppointmentsToAppointmentsResponse(appointments);
        return appointmentResponse;
    }

    private List<AppointmentResponse> mapListAppointmentsToAppointmentsResponse(List<Appointment> appointments){
        List<AppointmentResponse> appointmentResponse = appointments.stream()
                .map(appointmentMapper::AppointmentToAppointmentResponse)
                .collect(Collectors.toList());
        return appointmentResponse;
    }
}

