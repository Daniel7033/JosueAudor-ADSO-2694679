drop database tienda2;
create database tienda2;
use tienda2;
create table unidad_medida(
id bigint auto_increment primary key,
nombre varchar(50)
);
create table producto (
id bigint auto_increment primary key,
codigo varchar(50) not null,
nombre varchar(100) not null,
descripcion_corta varchar(1000),
descripcion_larga varchar(1000) not null,
precio double not null,
precio_costo double not null,
descuento double,
iva double not null 
-- categoria_id bigint not null,
-- foreign key(categoria_id) references categoria(id)
);
create table factura_detalle (
id bigint auto_increment primary key,
codigo varchar(50) not null,
cantidad integer not null,
precio_producto integer not null,
sub_total double not null,
descuento double not null,
iva double not null,
producto_id bigint not null,
foreign key(producto_id) references producto(id)
-- foreign key(factura_id) references factura(id),
);
create table insumo (
id bigint auto_increment primary key,
codigo varchar(50) not null,
nombre varchar(100) not null,
descripcion varchar(1000) not null,
unidad_medida_id bigint not null,
foreign key(unidad_medida_id) references unidad_medida(id)
);
create table insumo_producto (
id bigint auto_increment primary key,
cantidad integer not null,
adicional integer not null,
unidad_medida_id bigint not null,
insumo_id bigint not null,
producto_id bigint not null,
foreign key(unidad_medida_id) references unidad_medida(id),
foreign key(insumo_id) references insumo(id),
foreign key(producto_id) references producto(id)
);