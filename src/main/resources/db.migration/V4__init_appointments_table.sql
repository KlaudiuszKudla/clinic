CREATE TABLE "appointments"
(
    id                   serial primary key,
    office_id            BIGINT,
    patient_id           BIGINT,
    doctor_id            BIGINT,
    is_free              boolean default TRUE,
    is_finished          boolean default FALSE,
    note                 varchar,
    admission_start_time TIME,
    admission_end_time   TIME,
    admission_start_date DATE,
    admission_end_date   DATE,
    FOREIGN KEY (office_id) REFERENCES offices (id),
    FOREIGN KEY (patient_id) REFERENCES patients (id),
    FOREIGN KEY (doctor_id) REFERENCES doctors (id),
)