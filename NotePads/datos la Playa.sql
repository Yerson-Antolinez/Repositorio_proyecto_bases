use la_playa;

INSERT INTO UBICACION (id_ubicacion, nombre) VALUES
(1, 'stock'),
(2, 'bodega');



INSERT INTO TIPO_PRODUCTO (id_tipo, nombre, descripcion) VALUES
(1, 'Herbicida', 'Productos para el control de malas hierbas.'),
(2, 'Fungicida', 'Productos para el control de enfermedades en cultivos.'),
(3, 'Insecticida', 'Productos para el control de plagas en cultivos.'),
(4, 'Fertilizante', 'Productos para mejorar el crecimiento de las plantas.');


INSERT INTO PRODUCTO (id_producto, nombre, descripcion, cantidad, tipo_producto, precio, fecha_vencimiento, ubicacion) VALUES
(1, 'Glifosol', 'líquido de amplio espectro para el control de malas hierbas.',50, 1, 75000.00, '2024-12-31', 1),
(2, 'Manzate', 'líquido para el control de enfermedades en cultivos.',40, 2, 89000.00, '2025-06-30', 1),
(3, 'Pholition', 'líquido para el control de plagas en cultivos.',80, 3, 105000.00, '2024-09-30', 2),
(4, 'Curaxil', 'líquido para el control de malas hierbas en cultivos.',70, 1, 80000.00, '2025-03-31', 1),
(5, 'Nematron', 'líquido para el control de nematodos en suelos.',100, 4, 65000.00, '2024-11-30', 2),
(6, 'MaxiGrow', 'líquido de alta calidad para promover el crecimiento de plantas.',120, 1, 95000.00, '2024-10-31', 1),
(7, 'BioShield', 'líquido orgánico para proteger los cultivos contra enfermedades y plagas.',200, 2, 115000.00, '2025-07-30', 1);






INSERT INTO PROVEEDOR (id_proveedor, nombre_proveedor, correo_electronico, contacto, direccion) VALUES
(1, 'Agrosuministros S.A.', 'info@agrosuministros.com', '3107848564', 'Calle 123, Bogotá'),
(2, 'Fertilizantes Andinos', 'ventas@fertilizantesandinos.com', '3114567890', 'Carrera 456, Medellín'),
(3, 'Productos Agroquímicos S.A.', 'info@productosagroquimicos.com', '3124576478', 'Avenida 789, Cali');

		
INSERT INTO PEDIDO (proveedorid, fecha_pedido) VALUES
(1, '2024-04-17'),  -- Pedido al proveedor 1 realizado el 17 de abril de 2024
(2, '2024-04-18'),  -- Pedido al proveedor 2 realizado el 18 de abril de 2024
(3, '2024-04-19'),  -- Pedido al proveedor 3 realizado el 19 de abril de 2024
(1, '2024-04-20'),  -- Pedido al proveedor 1 realizado el 20 de abril de 2024
(2, '2024-04-21');  -- Pedido al proveedor 2 realizado el 21 de abril de 2024

INSERT INTO TIPO_CLIENTE (id_tipo_cliente, estado, descripcion) VALUES
(1, 'Particular', 'Clientes individuales que realizan compras no frecuentes.'),
(2, 'Fiado', 'Clientes que tienen la opción de comprar pero no pedir mas fiado.'),
(3, 'Preferencial', 'Clientes que reciben beneficios especiales y trato preferencial.');

INSERT INTO PRODUCTO_PEDIDO (id_producto, id_pedido) VALUES
(1, 1),  -- Producto Glifosol asociado al pedido 1
(2, 2),  -- Producto Manzate asociado al pedido 2
(3, 3),  -- Producto Pholition asociado al pedido 3
(4, 4),  -- Producto Curaxil asociado al pedido 4
(5, 5),  -- Producto Nematron asociado al pedido 5
(6, 3),  -- Producto MaxiGrow asociado al pedido 3
(7, 2),  -- Producto BioShield asociado al pedido 2
(2, 1),  -- Producto GreenGuard asociado al pedido 1
(3, 4),  -- Producto PlantMax asociado al pedido 4
(4, 1); -- Producto FruitPro asociado al pedido 1

INSERT INTO CLIENTE (id_cliente, nombre_cliente, tipo_cliente, contacto, direccion) VALUES
(1,'María Gómez', 2, 'maria@example.com', 'Carrera 456, Medellín'),
(2,'Juan Pérez', 1, 'juan@example.com', 'Calle 123, Bogotá'),
(3,'Pedro Rodríguez', 3, 'pedro@example.com', 'Avenida 789, Cali'),
(4,'Ana López', 1, 'ana@example.com', 'Calle 456, Bogotá'),
(5,'Luis Ramírez', 2, 'luis@example.com', 'Carrera 789, Medellín'),
(6,'Laura Martínez', 3, 'laura@example.com', 'Avenida 012, Cali');



INSERT INTO EMPLEADO (id_empleado, nombre_empleado, cargo, fecha_contratacion, contacto, salario) VALUES
(1, 'Ana García', 'Gerente de Ventas', '2020-05-15', 'ana@example.com', 1000000),
(2, 'Luis Martínez', 'Asistente de Almacén', '2021-02-10', 'luis@example.com', 2000000),
(3, 'María Rodríguez', 'Ingeniero Ambiental', '2019-08-25', 'maria@example.com', 4000000),
(4, 'Carlos López', 'Tecnico Agricola', '2022-03-18', 'carlos@example.com', 3500000),
(5, 'Pedro Sánchez', 'Obrero de Descargue', '2020-11-30', 'elena@example.com', 500000);



INSERT INTO VENTA (id_venta, clienteid, productoid, cantidad, fecha_venta, empleadoid, venta_total) VALUES
(1,1, 1, 3,'2024-04-17', 1,50000),
(2,2, 2,3, '2024-04-17', 2,60000),
(3,3, 3,5, '2024-04-17', 1,40000),
(4,4, 4,2, '2024-04-17', 1,700000),
(5,5, 5, 6,'2024-04-17', 2,300000);

