package com.example.clinic.controller;

import com.example.clinic.entity.office.Office;
import com.example.clinic.entity.office.OfficeResponse;
import com.example.clinic.entity.response.Code;
import com.example.clinic.entity.response.Response;
import com.example.clinic.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/office")
public class OfficeController {

    private final OfficeService officeService;

    @PostMapping
    public ResponseEntity<?> addOffice(@RequestParam int size){
        this.officeService.addOffice(size);
        return ResponseEntity.ok(new Response(Code.OFFICE_CREATED));
    }
    @GetMapping
    public ResponseEntity<OfficeResponse> getOffice(@RequestParam Long officeId){
        return this.officeService.getOfficeById(officeId);
    }
}
