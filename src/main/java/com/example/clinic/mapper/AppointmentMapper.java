package com.example.clinic.mapper;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.appointment.AppointmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {DoctorMapper.class, PatientMapper.class, OfficeMapper.class})
public abstract class AppointmentMapper {

//    @Mappings({
//            @Mapping(source = "doctorResponse", target = "doctor"),
//            @Mapping(source = "patientResponse", target = "patient"),
//            @Mapping(source = "officeResponse", target = "office")
//    })
    public abstract AppointmentResponse AppointmentToAppointmentResponse(Appointment appointment);
}
