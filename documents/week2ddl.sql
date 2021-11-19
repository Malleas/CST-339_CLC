create table cst_339."USER"
(
    user_id      serial
        constraint user_pk
            primary key,
    first_name   varchar(50) not null,
    last_name    varchar(50) not null,
    email        varchar(50) not null,
    phone_number varchar(50) not null,
    username     varchar(50) not null,
    password     varchar(50) not null
);

alter table cst_339."USER"
    owner to postgres;

create unique index user_email_uindex
    on cst_339."USER" (email);

create unique index user_username_uindex
    on cst_339."USER" (username);

