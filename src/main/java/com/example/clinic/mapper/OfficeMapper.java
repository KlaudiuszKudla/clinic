package com.example.clinic.mapper;

import com.example.clinic.entity.office.Office;
import com.example.clinic.entity.office.OfficeResponse;
import org.mapstruct.Mapper;

@Mapper
public abstract class OfficeMapper {

    public abstract OfficeResponse OfficeToOfficeResponse(Office office);
}
