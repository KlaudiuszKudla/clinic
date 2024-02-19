package com.example.clinic.entity;

public enum Code {
    DOCTOR_NOT_EXIST_WITH_SPECIALIZATION("Doktor od danej specjalizacji nie istnieje"),
    DOCTOR_CREATED("Utworzono doktora");
    public final String label;
    private Code(String label){
        this.label = label;
    }
}
