drop database if exists actividad_restaurante;
create database if not exists actividad_restaurante;
use actividad_restaurante;
create table if not exists restaurante(
	id bigint primary key auto_increment,
    nombre varchar(50) not null,
    direccion varchar(50) not null,
    tipo_cocina varchar(50) not null,
    menu varchar(50) not null,
    horario_atencion datetime not null,
    capacidad int not null
);