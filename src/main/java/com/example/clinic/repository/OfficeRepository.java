package com.example.clinic.repository;

import com.example.clinic.entity.office.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    public Optional<Office> findOfficeById(Long id);
}
