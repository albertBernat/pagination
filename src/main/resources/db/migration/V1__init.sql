create table make
(
    id      bigint not null
        constraint make_pkey primary key,
    name    varchar,
    country varchar
);

create table owner
(
    id          bigint not null
        constraint owner_pkey primary key,
    firstName   varchar,
    lastName    varchar,
    dateOfBirth date
);

CREATE TABLE car
(
    id                 bigint not null
        constraint car_pkey primary key,
    color              varchar,
    production_year    integer,
    production_country varchar,
    model              varchar,
    make_id            bigint REFERENCES make,
    owner_id           bigint REFERENCES owner
);

create table insurance
(
    id         bigint not null
        constraint insurance_pkey primary key,
    start_date date,
    end_date   date,
    car_id     bigint references car
);


