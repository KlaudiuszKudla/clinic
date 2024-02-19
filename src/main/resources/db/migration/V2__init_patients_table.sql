create TABLE "patients"
(
    id serial primary key,
    first_name varchar not null,
    last_name varchar not null,
    pesel varchar not null
)