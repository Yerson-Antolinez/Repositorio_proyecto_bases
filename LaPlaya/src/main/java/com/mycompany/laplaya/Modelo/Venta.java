/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Modelo;

/**
 *
 * @author Yerson
 */
public class Venta {
    private int id_venta;
    private int clienteid;
    private int productoid;
    private int cantidad;
    private String fecha_venta;
    private int empleadoid;
    private int venta_total;

    public Venta(int id_venta, int clienteid, int productoid, int cantidad, String fecha_venta, int empleadoid, int venta_total) {
        this.id_venta = id_venta;
        this.clienteid = clienteid;
        this.productoid = productoid;
        this.cantidad = cantidad;
        this.fecha_venta = fecha_venta;
        this.empleadoid = empleadoid;
        this.venta_total = venta_total;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }

    public int getVenta_total() {
        return venta_total;
    }

    public void setVenta_total(int venta_total) {
        this.venta_total = venta_total;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", clienteid=" + clienteid + ", productoid=" + productoid + ", cantidad=" + cantidad + ", fecha_venta=" + fecha_venta + ", empleadoid=" + empleadoid + ", venta_total=" + venta_total + '}';
    }

    
    
}