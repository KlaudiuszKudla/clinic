package com.example.clinic.service;

import com.example.clinic.entity.office.Office;
import com.example.clinic.entity.office.OfficeResponse;
import com.example.clinic.exception.OfficeDontExistException;
import com.example.clinic.mapper.OfficeMapper;
import com.example.clinic.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    public Office findOfficeById(Long id){
        return this.officeRepository.findOfficeById(id)
                .orElseThrow(() -> new OfficeDontExistException("Office dont exist"));

    }

    public void addOffice(int size) {
        Office office = new Office();
        office.setSize(size);
        officeRepository.saveAndFlush(office);
    }

    public ResponseEntity<OfficeResponse> getOfficeById(Long officeId) {
        Office office = officeRepository.findOfficeById(officeId)
                .orElseThrow(() -> new OfficeDontExistException("Office dont exist"));
        OfficeResponse officeResponse = officeMapper.OfficeToOfficeResponse(office);
        return ResponseEntity.ok().body(officeResponse);
    }
}
