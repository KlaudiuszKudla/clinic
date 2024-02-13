package com.example.clinic.entity;

public enum Code {
    USER_NOT_EXIST_WITH_SPECIALIZATION("Doktor od danej specjalizacji nie istnieje");

    public final String label;
    private Code(String label){
        this.label = label;
    }
}
