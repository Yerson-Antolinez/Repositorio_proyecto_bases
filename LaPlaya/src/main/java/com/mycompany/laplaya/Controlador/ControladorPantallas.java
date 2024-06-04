/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Controlador;

import com.mycompany.laplaya.Vista.VCliente;

import com.mycompany.laplaya.Vista.VEmpleado;
import com.mycompany.laplaya.Vista.VMenu;
import com.mycompany.laplaya.Vista.VProducto;
import com.mycompany.laplaya.Vista.VTipo_Cliente;
import com.mycompany.laplaya.Vista.VVenta;

/**
 *
 * @author Yerson
 */
public class ControladorPantallas {
   
    
    public static void abrirpantallaVMenu(){
        VMenu pantMenu = new VMenu();
        pantMenu.setVisible(true);
        pantMenu.setLocationRelativeTo(null);
    }
    
public static void salirpantallaVMenu(){
    VMenu pantMenu = new VMenu();
    pantMenu.dispose(); // Dispose of the window
    
}

     public static void abrirpantallaVCliente(){
        VCliente pantCliente = new VCliente();
        pantCliente.setVisible(true);
        pantCliente.setLocationRelativeTo(null);
    }
     public static void cerrarpantallaVCliente(){
        VCliente pantCliente = new VCliente();
        pantCliente.dispose();
        pantCliente.setLocationRelativeTo(null);
    }
     
    public static void abrirpantallaVEmpleado(){
        VEmpleado pantalla = new VEmpleado();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }
    
    public static void abrirpantallaVProducto(){
        VProducto pantalla = new VProducto();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }
    
    public static void abrirpantallaVTipo_Cliente(){
        VTipo_Cliente pantalla = new VTipo_Cliente();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }
    
    public static void abrirpantallaVVenta(){
        VVenta pantalla = new VVenta();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }
    
}
