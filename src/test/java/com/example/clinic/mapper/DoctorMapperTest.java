package com.example.clinic.mapper;

import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.doctor.DoctorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class DoctorMapperTest {

    private final DoctorMapper doctorMapper = new DoctorMapperImpl();

    private Doctor doctor;
    @BeforeEach
    public void init(){
        Doctor doctor1 = new Doctor();
        doctor1.setId(1L);
        doctor1.setFirstName("Adam");
        doctor1.setLastName("Nowak");
        doctor1.setSpecialization("laryngolog");
        this.doctor = doctor1;
    }

    @Test
    public void DoctorMapper_Map_Doctor_To_DoctorResponse(){
        DoctorResponse doctorResponse = doctorMapper.DoctorToDoctorResponse(doctor);
        // Then
        assertNotNull(doctorResponse);
        assertEquals(doctor.getFirstName(), doctorResponse.firstName());
        assertEquals(doctor.getLastName(), doctorResponse.lastName());
        assertEquals(doctor.getSpecialization(), doctorResponse.specialization());
    }

}