package com.example.clinic.entity.response;

public enum Code {
    DOCTOR_NOT_EXIST_WITH_SPECIALIZATION("Doktor od danej specjalizacji nie istnieje"),
    DOCTOR_CREATED("Utworzono doktora"),
    DOCTOR_NOT_EXIST("Doktor o podanych danych nie istnieje"),
    APPOINTMENT_CREATED("Utworzono wizyte"),
    APPOINTMENT_NOT_EXIST("Wizyta o podanych danych nie istnieje"),
    APPOINTMENT_NOT_EXIST_WITH_DOCTOR("Wizyta dla danego lekarza nie istnieje"),
    OFFICE_CREATED("Utworzono gabinet");
    public final String label;
    private Code(String label){
        this.label = label;
    }
}
