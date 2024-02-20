package com.example.clinic.service;

import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.entity.doctor.DoctorCreatorDTO;
import com.example.clinic.exception.DoctorDontExistException;
import com.example.clinic.repository.DoctorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    @PersistenceContext
    EntityManager entityManager;

    private final DoctorRepository doctorRepository;
    public ResponseEntity<Doctor> getDoctorBySpecialization(String specialization) throws DoctorDontExistException {
        var doctor = doctorRepository.findDoctorBySpecialization(specialization).orElse(null);
        if(doctor != null){
            return ResponseEntity.ok(doctor);
        }else {
            throw new DoctorDontExistException("Doctor dont exist");
        }
    }

    public void addDoctor(DoctorCreatorDTO doctorCreatorDTO) {
        var doctor = new Doctor();
        doctor.setFirstName(doctorCreatorDTO.getFirstName());
        doctor.setLastName(doctorCreatorDTO.getLastName());
        doctor.setSpecialization(doctorCreatorDTO.getSpecialization());
        doctorRepository.saveAndFlush(doctor);
    }

    public List<Doctor> getDoctor(int page, int limit, String firstName, String lastName, String specialization, String sort, String order) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Doctor> query = criteriaBuilder.createQuery(Doctor.class);
        Root<Doctor> root = query.from(Doctor.class);
        List<Predicate> predicates = prepareQuery(firstName, lastName,specialization, criteriaBuilder, root);
        if(page<=0){
            page = 1;
        }
        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }

    private List<Predicate> prepareQuery(String firstName, String lastName, String specialization, CriteriaBuilder criteriaBuilder, Root<Doctor> root) {
        List<Predicate> predicates = new ArrayList<>();
        if(firstName != null && !firstName.trim().equals("")){
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%"));
        }
        if(lastName != null && !lastName.trim().equals("")){
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%"));
        }
        if(specialization != null && !specialization.trim().equals("")){
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("specialization")), "%" + specialization.toLowerCase() + "%"));
        }
        return predicates;
    }


    public Doctor findDoctorById(Long doctorId) throws DoctorDontExistException{
        return this.doctorRepository.findDoctorById(doctorId)
                .orElseThrow(() -> new DoctorDontExistException("Doctor not found with ID: " + doctorId));
    }
}
