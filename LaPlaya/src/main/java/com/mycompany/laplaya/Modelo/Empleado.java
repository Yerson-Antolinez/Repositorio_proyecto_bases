/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Yerson
 */
public class Empleado {
    private int id_empleado;
    private String nombre_empleado;
    private String cargo;
    private String fecha_contratacion;
    private String contacto;
    private int salario;

    public Empleado(int id_empleado, String nombre_empleado, String cargo, String fecha_contratacion, String contacto, int salario) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.cargo = cargo;
        this.fecha_contratacion = fecha_contratacion;
        this.contacto = contacto;
        this.salario = salario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_empleado=" + id_empleado + ", nombre_empleado=" + nombre_empleado + ", cargo=" + cargo + ", fecha_contratacion=" + fecha_contratacion + ", contacto=" + contacto + ", salario=" + salario + '}';
    }

    
   
   

    
    
    
}