Drop database if exists ubicacion;
create database if not exists ubicacion;
use ubicacion;
create table if not exists continente (
	 id bigINT PRIMARY KEY auto_increment,
	 codigo VARCHAR(20),
    nombre VARCHAR(20),
    estado BOOLEAN,
    fecha_creacion DATETIME, 
    fecha_modificacion DATETIME, 
    fecha_eliminacion DATETIME
);
create table if not exists pais (
	id bigINT PRIMARY KEY auto_increment,
    codigo VARCHAR(20),
    nombre VARCHAR(20),
    estado BOOLEAN,
    fecha_creacion DATETIME, 
    fecha_modificacion DATETIME, 
    fecha_eliminacion DATETIME,
    continente_id BIGINT,
    foreign key (continente_id) references continente(id)
);
create table if not exists departamento (
	id bigINT PRIMARY KEY auto_increment,
    codigo VARCHAR(20),
    nombre VARCHAR(20),
    estado BOOLEAN,
    fecha_creacion DATETIME, 
    fecha_modificacion DATETIME, 
    fecha_eliminacion DATETIME,
    pais_id bigINT,
    foreign key (pais_id) references pais(id)
);
create table if not exists ciudad (
	id bigINT PRIMARY KEY auto_increment,
    codigo VARCHAR(20),
    nombre VARCHAR(20),
    estado BOOLEAN,
    fecha_creacion DATETIME, 
    fecha_modificacion DATETIME, 
    fecha_eliminacion DATETIME,
    departamento_id bigINT,
    foreign key (departamento_id) references departamento(id)
);
