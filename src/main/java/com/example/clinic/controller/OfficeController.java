package com.example.clinic.controller;

import com.example.clinic.entity.response.Code;
import com.example.clinic.entity.response.Response;
import com.example.clinic.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
