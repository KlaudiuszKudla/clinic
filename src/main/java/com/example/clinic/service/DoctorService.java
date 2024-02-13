package com.example.clinic.service;

import com.example.clinic.entity.Doctor;
import com.example.clinic.exception.DocktorDontExistException;
import com.example.clinic.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    public ResponseEntity<Doctor> getDoctorBySpecialization(String specialization) throws DocktorDontExistException {
        var doctor = doctorRepository.findDoctorBySpecialization(specialization).orElse(null);
        if(doctor != null){
            return ResponseEntity.ok(doctor);
        }else {
            throw new DocktorDontExistException("Doctor dont exist");
        }
    }
}
