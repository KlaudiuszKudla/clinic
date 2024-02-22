package com.example.clinic.mapper;

import com.example.clinic.entity.appointment.Appointment;
import com.example.clinic.entity.appointment.AppointmentResponse;
import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.office.Office;
import com.example.clinic.entity.patient.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class AppointmentMapperTest {

    @Mock
    private final DoctorMapper doctorMapper = Mappers.getMapper(DoctorMapper.class);
    @Mock
    private final PatientMapper patientMapper = Mappers.getMapper(PatientMapper.class);
    @Mock
    private final OfficeMapper officeMapper = Mappers.getMapper(OfficeMapper.class);
    @InjectMocks
    private final AppointmentMapper appointmentMapper = new AppointmentMapperImpl();

    private Appointment appointment;
    @BeforeEach
    public void init(){
        Doctor doctor = new Doctor();
        doctor.setFirstName("Adam");
        doctor.setLastName("Nowak");
        doctor.setSpecialization("laryngolog");

        Office office = new Office();
        office.setSize(10);

        Patient patient = new Patient();
        patient.setFirstName("Adam");
        patient.setLastName("Grey");
        patient.setPesel("01271210457");

        Appointment appointment = new Appointment();
        appointment.setOffice(office);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setFree(true);
        appointment.setFinished(false);
        appointment.setNote("good");
        appointment.setAdmissionDate(LocalDate.now());
        appointment.setAdmissionStartTime(LocalTime.now());
        appointment.setAdmissionEndTime(LocalTime.now().plusMinutes(20));
        this.appointment = appointment;
    }

    @Test
    public void AppointmentMapper_AppointmentToAppointmentResponse_Test(){

        AppointmentResponse appointmentResponse = appointmentMapper.AppointmentToAppointmentResponse(this.appointment);

        assertNotNull(appointmentResponse);
        assertEquals(appointmentResponse.doctor().firstName(), appointment.getDoctor().getFirstName());
        assertEquals(appointmentResponse.doctor().lastName(), appointment.getDoctor().getLastName());
        assertEquals(appointmentResponse.doctor().specialization(), appointment.getDoctor().getSpecialization());

        assertEquals(appointmentResponse.office().size(), appointment.getOffice().getSize());

        assertEquals(appointmentResponse.patient().firstName(), appointment.getPatient().getFirstName());
        assertEquals(appointmentResponse.patient().lastName(), appointment.getPatient().getLastName());
        assertEquals(appointmentResponse.patient().pesel(), appointment.getPatient().getPesel());

        assertEquals(appointmentResponse.isFree(), appointment.isFree());
        assertEquals(appointmentResponse.isFinished(), appointment.isFinished());
        assertEquals(appointmentResponse.note(), appointment.getNote());
        assertEquals(appointmentResponse.admissionDate(), appointment.getAdmissionDate());
        assertEquals(appointmentResponse.admissionStartTime(), appointment.getAdmissionStartTime());
        assertEquals(appointmentResponse.admissionEndTime(), appointment.getAdmissionEndTime());
    }
}
