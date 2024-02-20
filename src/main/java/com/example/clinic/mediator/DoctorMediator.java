package com.example.clinic.mediator;

import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DoctorMediator {

    private final DoctorService doctorService;

    public ResponseEntity<?> getDoctor(int page, int limit, String firstName, String lastName, String specialization, String sort, String order){
//        long totalCount = doctorService.countDoctors();
        List<Doctor> doctorList = doctorService.getDoctor(page, limit, firstName, lastName, specialization, sort,order);
        return ResponseEntity.ok().body(doctorList);
    }
}
