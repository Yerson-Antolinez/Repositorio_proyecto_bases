
---este tiguer hace que cuando registremos un estado, la descripcion se inserte automaticamente acorde al estado
DELIMITER //

CREATE TRIGGER before_insert_tipo_cliente
BEFORE INSERT ON TIPO_CLIENTE
FOR EACH ROW
BEGIN
    IF NEW.estado = 'Particular' THEN
        SET NEW.descripcion = 'Clientes individuales que realizan compras para uso personal.';
    ELSEIF NEW.estado = 'Fiado' THEN
        SET NEW.descripcion = 'Clientes que tienen la opción de comprar a crédito.';
    ELSEIF NEW.estado = 'Preferencial' THEN
        SET NEW.descripcion = 'Clientes que reciben beneficios especiales y trato preferencial.';
    END IF;
END;
//

DELIMITER ;






--- este tigguer resta las cantidades de la tabla producto cuando se hace una venta
DELIMITER //

CREATE TRIGGER actualizar_cantidad_producto 
AFTER INSERT ON VENTA
FOR EACH ROW
BEGIN
    UPDATE PRODUCTO
    SET cantidad = cantidad - NEW.cantidad
    WHERE id_producto = NEW.productoid;
END//

DELIMITER ;

---este tiguer hace que cuando modifique un estado, la descripcion se inserte automaticamente acorde al estado
DELIMITER //

CREATE TRIGGER before_update_tipo_cliente
BEFORE UPDATE ON TIPO_CLIENTE
FOR EACH ROW
BEGIN
    IF NEW.estado = 'Particular' THEN
        SET NEW.descripcion = 'Clientes individuales que realizan compras para uso personal.';
    ELSEIF NEW.estado = 'Fiado' THEN
        SET NEW.descripcion = 'Clientes que tienen la opción de comprar a crédito.';
    ELSEIF NEW.estado = 'Preferencial' THEN
        SET NEW.descripcion = 'Clientes que reciben beneficios especiales y trato preferencial.';
    END IF;
END;
//

DELIMITER ;


---en caso de actualizar la cantidad devuelve los productos
DELIMITER //

CREATE TRIGGER actualizar_cantidad_producto_modificacion
AFTER UPDATE ON VENTA
FOR EACH ROW
BEGIN
    DECLARE cantidad_vendida INT;
    DECLARE diferencia_cantidad INT;

    IF OLD.cantidad <> NEW.cantidad THEN
        SET cantidad_vendida = OLD.cantidad - NEW.cantidad;
        UPDATE PRODUCTO
        SET cantidad = cantidad + cantidad_vendida
        WHERE id_producto = NEW.productoid;
    END IF;
END//

DELIMITER ;



