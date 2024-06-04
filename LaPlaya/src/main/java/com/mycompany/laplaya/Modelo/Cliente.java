/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Modelo;

/**
 *
 * @author Yerson
 */
public class Cliente {
    private int id_cliente;
    private String nombre_cliente;
    private int tipo_cliente;
    private String contacto;
    private String direccion;

    public Cliente(int id_cliente, String nombre_cliente, int tipo_cliente, String contacto, String direccion) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.tipo_cliente = tipo_cliente;
        this.contacto = contacto;
        this.direccion = direccion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(int tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombre_cliente=" + nombre_cliente + ", tipo_cliente=" + tipo_cliente + ", contacto=" + contacto + ", direccion=" + direccion + '}';
    }
    
    
}
