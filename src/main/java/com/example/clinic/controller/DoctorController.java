package com.example.clinic.controller;

import com.example.clinic.entity.Code;
import com.example.clinic.entity.Doctor;
import com.example.clinic.entity.Response;
import com.example.clinic.exception.DocktorDontExistException;
import com.example.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    public ResponseEntity<?> getDoctorBySpecialization(@RequestParam String specialization){
        try {
            return this.doctorService.getDoctorBySpecialization(specialization);
        } catch (DocktorDontExistException e){
            return ResponseEntity.status(401).body(new Response(Code.USER_NOT_EXIST_WITH_SPECIALIZATION));
        }
    }
}
