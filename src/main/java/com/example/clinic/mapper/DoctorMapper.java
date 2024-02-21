package com.example.clinic.mapper;

import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.doctor.DoctorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class DoctorMapper {

//    @Mappings({
//            @Mapping(target = "firstName", source = "firstName")
//    })
    public abstract DoctorResponse DoctorToDoctorResponse(Doctor doctor);
}
