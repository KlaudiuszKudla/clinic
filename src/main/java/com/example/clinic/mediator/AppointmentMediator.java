package com.example.clinic.mediator;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.appointment.AppointmentCreatorDTO;
import com.example.clinic.entity.appointment.AppointmentResponse;
import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.office.Office;
import com.example.clinic.entity.response.Code;
import com.example.clinic.entity.response.Response;
import com.example.clinic.mapper.AppointmentMapper;
import com.example.clinic.service.AppointmentService;
import com.example.clinic.service.DoctorService;
import com.example.clinic.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppointmentMediator {

    private final DoctorService doctorService;
    private final OfficeService officeService;
    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;
    public ResponseEntity<Response> addAppointment(AppointmentCreatorDTO appointmentCreatorDTO){
        Doctor doctor = this.doctorService.findDoctorById(appointmentCreatorDTO.getDoctorId());
        Office office = this.officeService.findOfficeById(appointmentCreatorDTO.getOfficeId());
        this.appointmentService.addAppointment(doctor, office, appointmentCreatorDTO);
        return ResponseEntity.ok(new Response(Code.APPOINTMENT_CREATED));
    }

    public ResponseEntity<List<AppointmentResponse>> getAppointmentByDoctor(Long doctorId){
        Doctor doctor = this.doctorService.findDoctorById(doctorId);
        List<Appointment> appointments = this.appointmentService.getAppointmentsByDoctor(doctor);
        List<AppointmentResponse> appointmentResponses = appointments.stream()
                .map(appointmentMapper::AppointmentToAppointmentResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(appointmentResponses);
    }
}
