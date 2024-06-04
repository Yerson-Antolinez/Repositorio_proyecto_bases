/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laplaya;

import com.mycompany.laplaya.Controlador.Conexion;
import com.mycompany.laplaya.Controlador.ControladorPantallas;
import com.mycompany.laplaya.Vista.VCliente;
import com.mycompany.laplaya.Vista.VEmpleado;
import com.mycompany.laplaya.Vista.VMenu;
import com.mycompany.laplaya.Vista.VProducto;
import com.mycompany.laplaya.Vista.VTipo_Cliente;

/**
 *
 * @author Yerson
 */
public class LaPlaya {

    public static void main(String[] args) {
        
        Conexion cn = new Conexion();
        cn.conectar();
        ControladorPantallas.abrirpantallaVMenu();
//        
        
//        VProducto pantProducto = new VProducto();
//        pantProducto.setVisible(true);
//        pantProducto.setLocationRelativeTo(null);
        
//        VCliente pantCliente = new VCliente();
//        pantCliente.setVisible(true);
//        pantCliente.setLocationRelativeTo(null);
        
        
//        VMenu pantClient = new VMenu();
//        pantClient.setVisible(true);
//        pantClient.setLocationRelativeTo(null);
        
        
//        VEmpleado pantEmpleado = new VEmpleado();
//        pantEmpleado.setVisible(true);
//        pantEmpleado.setLocationRelativeTo(null);
//                
//                
                
//        VTipo_Cliente pantTipoCliente= new VTipo_Cliente();
//        pantTipoCliente.setVisible(true);
//        pantTipoCliente.setLocationRelativeTo(null);
//        
    }
}
