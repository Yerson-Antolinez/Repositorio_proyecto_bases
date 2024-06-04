/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yerson
 */
public class Conexion {
    private static Connection conect;
    
    public  void conectar() {
        String url = "jdbc:mysql://localhost:3306/la_playa? serverTimezone=UTC";
        String usr = "root";
        String ctr = "yerson11747";
        
        try {
            conect = DriverManager.getConnection(url, usr, ctr);
            JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "CONEXION FALLIDA");
        }
    
    
    
    
           }

    public static Connection getConect() {
        return conect;
    }

    public static void setConect(Connection conect) {
        Conexion.conect = conect;
    }
    
    
}
