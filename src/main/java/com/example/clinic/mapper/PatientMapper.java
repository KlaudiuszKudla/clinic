package com.example.clinic.mapper;

import com.example.clinic.entity.patient.Patient;
import com.example.clinic.entity.patient.PatientResponse;
import org.mapstruct.Mapper;

@Mapper
public abstract class PatientMapper {

    public abstract PatientResponse PatientToPatientResponse(Patient patient);

}
