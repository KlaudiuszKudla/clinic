package com.example.clinic.mediator;

import com.example.clinic.entity.appointment.AppointmentCreatorDTO;
import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.office.Office;
import com.example.clinic.entity.response.Code;
import com.example.clinic.entity.response.Response;
import com.example.clinic.exception.DoctorDontExistException;
import com.example.clinic.service.AppointmentService;
import com.example.clinic.service.DoctorService;
import com.example.clinic.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMediator {

    private final DoctorService doctorService;
    private final OfficeService officeService;
    private final AppointmentService appointmentService;
    public ResponseEntity<Response> addAppointment(AppointmentCreatorDTO appointmentCreatorDTO) throws DoctorDontExistException {
        Doctor doctor = this.doctorService.findDoctorById(appointmentCreatorDTO.getDoctorId());
        Office office = this.officeService.findOfficeById(appointmentCreatorDTO.getOfficeId());
        this.appointmentService.addAppointment(doctor, office, appointmentCreatorDTO);
        return ResponseEntity.ok(new Response(Code.APPOINTMENT_CREATED));
    }
}
