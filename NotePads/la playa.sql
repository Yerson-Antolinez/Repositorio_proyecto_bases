CREATE DATABASE LA_PLAYA;
USE LA_PLAYA;

CREATE TABLE UBICACION ( 
id_ubicacion int not null primary key ,
nombre varchar(250)
);

CREATE TABLE EMPLEADO ( 
id_empleado int not null primary key,
nombre_empleado varchar(250),
cargo varchar(250),
fecha_contratacion DATE,
contacto varchar (250),
salario int
);

CREATE TABLE TIPO_PRODUCTO( 
id_tipo int not null primary key,
nombre varchar(250),
descripcion varchar(250)
);

CREATE TABLE TIPO_CLIENTE( 
id_tipo_cliente int not null primary key,
estado varchar(250),
descripcion varchar(250)
);

CREATE TABLE PROVEEDOR ( 
id_proveedor int not null primary key,
nombre_proveedor varchar(250),
correo_electronico varchar(250),
contacto varchar(250),
direccion varchar (250)
);

CREATE TABLE CLIENTE ( 
id_cliente int not null primary key,
nombre_cliente varchar(250),
tipo_cliente int,
contacto varchar(250),
direccion varchar (250),
CONSTRAINT cliente_tipo_cliente_fk FOREIGN key (tipo_cliente) REFERENCES TIPO_CLIENTE(id_tipo_cliente)
);

CREATE TABLE PEDIDO ( 
id_pedido int not null primary key AUTO_INCREMENT,
proveedorid int,
fecha_pedido DATE,
CONSTRAINT pedido_proveedor_fk FOREIGN key (proveedorid) REFERENCES PROVEEDOR(id_proveedor)
);

CREATE TABLE PRODUCTO (
id_producto int not null primary key, 
nombre varchar(250),
descripcion varchar(250),
cantidad int,
tipo_producto int,
precio int,
fecha_vencimiento DATE,
ubicacion int,
CONSTRAINT producto_tipo_producto_fk FOREIGN key (tipo_producto) REFERENCES TIPO_PRODUCTO(id_tipo),
CONSTRAINT producto_ubicacion_fk FOREIGN key (ubicacion) REFERENCES UBICACION(id_ubicacion)
);

CREATE TABLE VENTA ( 
id_venta int not null primary key,
clienteid int,
productoid int,
cantidad int,
fecha_venta DATE,
empleadoid int,
venta_total int,
CONSTRAINT venta_empleado_fk FOREIGN key (empleadoid) REFERENCES EMPLEADO(id_empleado),
CONSTRAINT venta_cliente_fk FOREIGN key (clienteid) REFERENCES CLIENTE(id_cliente),
CONSTRAINT venta_producto_fk FOREIGN key (productoid) REFERENCES PRODUCTO(id_producto)
);





CREATE TABLE PRODUCTO_PEDIDO(
id_producto int not null, 
id_pedido int not null,
primary key (id_producto,id_pedido),
CONSTRAINT producto_pedido_productos_fk FOREIGN key (id_producto) REFERENCES PRODUCTO(id_producto),
CONSTRAINT producto_pedido_pedido_fk FOREIGN key (id_pedido) REFERENCES PEDIDO(id_pedido)
);


