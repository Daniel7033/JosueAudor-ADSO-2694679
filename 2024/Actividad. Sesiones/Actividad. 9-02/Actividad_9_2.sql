drop database actividad_9_2;
create database if not exists actividad_9_2;
use actividad_9_2;
create table if not exists restaurante (
	id bigint primary KEY auto_increment,
    nombre varchar(50) not null,
    direccion varchar(50) not null,
    tipo_cocina varchar(50) not null,
    horario_atencion datetime not null,
    capacidad int not null,
    menu varchar(30000) not null
);
