create table if not exists users
(
    id         BIGINT auto_increment primary key,
    first_name varchar(30),
    last_name  varchar(30),
    country_id BIGINT,
    username   varchar(40),
    password   varchar(20),
    email      varchar(100)
);

create table if not exists garages
(
    id     BIGINT auto_increment primary key,
    street varchar(40),
    floors int
);

create table if not exists parking_spaces
(
    id         BIGINT auto_increment primary key,
    garage_id  BIGINT,
    floor      int,
    vehicle_id BIGINT
);

create table if not exists makes
(
    id   BIGINT auto_increment primary key,
    name varchar(30)
);

create table if not exists vehicles
(
    id            BIGINT auto_increment primary key,
    make_id       BIGINT,
    license_plate varchar(12),
    color         varchar(10)
);




