package com.example.clinic.service;

import com.example.clinic.entity.doctor.Doctor;
import com.example.clinic.repository.DoctorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {


    @MockBean
    private DoctorRepository doctorRepository;
    @MockBean
    private EntityManager entityManager;
    @Mock
    private CriteriaBuilder criteriaBuilder;
    @Mock
    private CriteriaQuery<Doctor> criteriaQuery;
    @Mock
    private Root<Doctor> root;
    @Mock
    private TypedQuery<Doctor> typedQuery;
    @InjectMocks
    private DoctorService doctorService;

    @DisplayName("UserService prepareQuery test")
    @ParameterizedTest(name = "{3}")
    @MethodSource("prepareQueryData")
    public void parametrizedTests(int page, int limit, String firstName, String lastName, String specialization, String sort, String order){
//        List<Predicate> predicates = new ArrayList<>();
//        when(doctorService.prepareQuery(firstName, lastName, specialization, criteriaBuilder, root)).thenReturn(predicates);

        // Mockowanie entityManager
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery(Doctor.class)).thenReturn(criteriaQuery);
        when(criteriaQuery.from(Doctor.class)).thenReturn(root);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(new ArrayList<>());

        // Wywołanie metody do przetestowania
        List<Doctor> result = doctorService.getDoctor(page, limit, firstName, lastName, specialization, sort, order);

        // Sprawdzenie, czy metody były wywoływane z odpowiednimi argumentami
        verify(criteriaBuilder).like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
        verify(criteriaBuilder).like(criteriaBuilder.lower(root.get("lastName")), "%" + lastName.toLowerCase() + "%");
        verify(criteriaBuilder).like(criteriaBuilder.lower(root.get("specialization")), "%" + specialization.toLowerCase() + "%");
        verify(entityManager).createQuery(criteriaQuery);
    }

    private static Stream<Arguments> prepareQueryData(){
        return Stream.of(
                Arguments.of(1,10,"John", "Doe", "Cardiologist", "firstName", "desc"),
                Arguments.of(1,10,"John", "Doe", null, "firstName", "desc"),
                Arguments.of(1,10,"John", null, null, "firstName", "desc"),
                Arguments.of(1,10,null, null, null, "firstName", "desc")
        );
    }
    @Test
    void getDoctorBySpecialization() {
    }

    @Test
    void addDoctor() {
    }

    @Test
    void getDoctor() {
    }
}