package com.example.clinic.controller;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.response.Code;
import com.example.clinic.entity.doctor.DoctorCreatorDTO;
import com.example.clinic.entity.response.Response;
import com.example.clinic.mediator.DoctorMediator;
import com.example.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMediator doctorMediator;

//    @GetMapping
//    public ResponseEntity<?> getDoctorBySpecialization(@RequestParam String specialization){
//        try {
//            return this.doctorService.getDoctorBySpecialization(specialization);
//        } catch (DocktorDontExistException e){
//            return ResponseEntity.status(401).body(new Response(Code.DOCTOR_NOT_EXIST_WITH_SPECIALIZATION));
//        }
//    }

    @GetMapping()
    public ResponseEntity<?> get(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName,
                                 @RequestParam(required = false) String specialization,
                                 @RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int limit,
                                 @RequestParam(required = false, defaultValue = "specialization") String sort,
                                 @RequestParam(required = false, defaultValue = "asc") String order){
        return doctorMediator.getDoctor(page, limit, firstName, lastName, specialization, sort,order);
    }

    @PostMapping
    public ResponseEntity<?> addDoctor(@RequestBody DoctorCreatorDTO doctorCreatorDTO){
        this.doctorService.addDoctor(doctorCreatorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Code.DOCTOR_CREATED));
    }

}
