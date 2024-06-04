/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Modelo;

/**
 *
 * @author Yerson
 */
public class Tipo_Cliente {
        private int id_tipo_cliente;
        private String estado;
        private String descripcion;

    public Tipo_Cliente(int id_tipo_cliente, String estado, String descripcion) {
        this.id_tipo_cliente = id_tipo_cliente;
        this.estado = estado;
        this.descripcion = descripcion;
    }

   

    public int getId_tipo_cliente() {
        return id_tipo_cliente;
    }

    public void setId_tipo_cliente(int id_tipo_cliente) {
        this.id_tipo_cliente = id_tipo_cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tipo_Cliente{" + "id_tipo_cliente=" + id_tipo_cliente + ", estado=" + estado + ", descripcion=" + descripcion + '}';
    }
        
        
        
}
