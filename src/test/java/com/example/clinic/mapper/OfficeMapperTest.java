package com.example.clinic.mapper;

import com.example.clinic.entity.office.Office;
import com.example.clinic.entity.office.OfficeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class OfficeMapperTest {

    private final OfficeMapper officeMapper = new OfficeMapperImpl();
    private Office office;

    @BeforeEach
    public void init(){
        Office office = new Office();
        office.setSize(10);
        this.office = office;
    }

    @Test
    public void OfficeMapper_Office_Map_To_OfficeResponse(){
        OfficeResponse officeResponse = officeMapper.OfficeToOfficeResponse(office);

        assertNotNull(officeResponse);
        assertEquals(office.getSize(), officeResponse.size());

    }


}
