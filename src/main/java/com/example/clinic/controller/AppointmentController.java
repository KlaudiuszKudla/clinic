package com.example.clinic.controller;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.appointment.AppointmentCreatorDTO;
import com.example.clinic.entity.response.Code;
import com.example.clinic.entity.response.Response;
import com.example.clinic.exception.AppointmentDontExistException;
import com.example.clinic.exception.DoctorDontExistException;
import com.example.clinic.mediator.AppointmentMediator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/appointment")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentMediator appointmentMediator;

    @PostMapping
    public ResponseEntity<Response> addAppointment(@RequestBody AppointmentCreatorDTO appointmentCreatorDTO){
         return this.appointmentMediator.addAppointment(appointmentCreatorDTO);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointmentByDoctor(@RequestParam Long doctorId){
        return this.appointmentMediator.getAppointmentByDoctor(doctorId);
    }


}
