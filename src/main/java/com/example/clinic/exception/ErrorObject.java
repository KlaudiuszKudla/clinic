package com.example.clinic.exception;

import lombok.Data;
@Data
public class ErrorObject {

    private Integer statusCode;
    private String message;
    private Data timestamp;
}
