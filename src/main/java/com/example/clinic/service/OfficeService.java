package com.example.clinic.service;

import com.example.clinic.entity.office.Office;
import com.example.clinic.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;

    public Office findOfficeById(Long id){
        return this.officeRepository.findOfficeById(id).orElse(null);
    }

    public void addOffice(int size) {
        Office office = new Office();
        office.setSize(size);
        officeRepository.saveAndFlush(office);
    }
}
