package com.example.clinic.repository;

import com.example.clinic.entity.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findDoctorBySpecialization(String specialization);

    Optional<Doctor> findDoctorById(Long doctorId);
}
