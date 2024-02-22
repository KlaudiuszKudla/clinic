package com.example.clinic.mapper;

import com.example.clinic.entity.patient.Patient;
import com.example.clinic.entity.patient.PatientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientMapperTest {

    private final PatientMapper patientMapper = new PatientMapperImpl();
    private Patient patient;
    @BeforeEach
    public void init(){
        Patient patient = new Patient();
        patient.setFirstName("Adam");
        patient.setLastName("Grey");
        patient.setPesel("01271210457");
        this.patient = patient;

    }

    @Test
    public void PatientMapper_PatientToPatientResponse_Test(){
        PatientResponse patientResponse = patientMapper.PatientToPatientResponse(patient);

        assertNotNull(patientResponse);
        assertEquals(patient.getFirstName(), patientResponse.firstName());
        assertEquals(patient.getLastName(), patientResponse.lastName());
        assertEquals(patient.getPesel(), patientResponse.pesel());
    }

}
