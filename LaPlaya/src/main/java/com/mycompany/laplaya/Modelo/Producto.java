/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Modelo;

/**
 *
 * @author Asus
 */
public class Producto {
    private int id_producto;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private int tipo_producto;
    private int precio;
    private String fecha_vencimiento;
    private int ubicacion;

    public Producto(int id_producto, String nombre, String descripcion, int cantidad, int tipo_producto, int precio, String fecha_vencimiento, int ubicacion) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo_producto = tipo_producto;
        this.precio = precio;
        this.fecha_vencimiento = fecha_vencimiento;
        this.ubicacion = ubicacion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(int tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", tipo_producto=" + tipo_producto + ", precio=" + precio + ", fecha_vencimiento=" + fecha_vencimiento + ", ubicacion=" + ubicacion + '}';
    }
    
    
    
}
