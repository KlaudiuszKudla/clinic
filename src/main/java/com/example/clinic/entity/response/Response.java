package com.example.clinic.entity.response;

import com.example.clinic.entity.response.Code;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Response {

    private final String message;
    private final Code code;
    private final String timestamp;

    public Response(Code code) {
        this.timestamp = String.valueOf(new Timestamp(System.currentTimeMillis()));
        this.code = code;
        this.message = code.label;
    }
}
