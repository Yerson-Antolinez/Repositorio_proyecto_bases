/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Controlador;

import com.mycompany.laplaya.Modelo.Empleado;
import com.mysql.cj.xdevapi.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yerson
 */
public class CEmpleado {

    public void registrarEmpleado(Empleado empleado) {
        try {
            Statement Em = Conexion.getConect().createStatement();
            Em.execute("insert into empleado(id_empleado, nombre_empleado, cargo, fecha_contratacion, contacto, salario)values( '" + empleado.getId_empleado() + "','" + empleado.getNombre_empleado() + "','" + empleado.getCargo() + "', '" + empleado.getFecha_contratacion() + "', '" + empleado.getContacto() + "', '" + empleado.getSalario() + "')");
            JOptionPane.showMessageDialog(null, "Registrado");
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Registrar");
        }

    }

    public void eliminarEmpleado(Empleado empleado) {
        try {
            Statement Em = Conexion.getConect().createStatement();
            Em.execute("delete from empleado where id_empleado = ('" + empleado.getId_empleado() + "')");
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Eliminar");
        }

    }
    
     public void modificarEmpleado(Empleado empleado){  // crea el metodo para eliminar el cliente
        try {
            Statement tc = Conexion.getConect().createStatement();
            tc.execute("update empleado set nombre_empleado = '"+empleado.getNombre_empleado()+"', cargo = '"+empleado.getCargo()+"', fecha_contratacion = '"+empleado.getFecha_contratacion()+"', contacto = '"+empleado.getContacto()+"', salario = '"+empleado.getSalario()+"' where id_empleado = '"+empleado.getId_empleado()+"'");
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(CTipo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "fallo al modificar");}
    
    }

    public void cargarComboBoxEmpleado(JComboBox combo) { //esto carga el combo box con la base de datos

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select cargo from empleado group by cargo");
           model.addElement("Seleccione");    //aqui va un if
            while (rs.next()) {                
                model.addElement(rs.getString("cargo"));
            }
           combo.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    public void cargarTablaEmpleado(JTable tabla) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Empleado");
        model.addColumn("Nombre");
        model.addColumn("Cargo");
        model.addColumn("Fecha Contratacion");
        model.addColumn("Contacto");
        model.addColumn("Salario");
 
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select * from empleado ");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("id_empleado"),rs.getString("nombre_empleado"),rs.getString("cargo"), rs.getString("fecha_contratacion"), rs.getString("contacto"), rs.getString("salario")};
                model.addRow(fila);
            }
           tabla.setModel(model);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         
    }
    


 public void buscarEmpleado(JTable tabla, String nombre) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Empleado");
        model.addColumn("Nombre");
        model.addColumn("Cargo");
        model.addColumn("Fecha Contratacion");
        model.addColumn("Contacto");
        model.addColumn("Salario");
     
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM empleado WHERE LOWER(nombre_empleado) = (SELECT LOWER(nombre_empleado) FROM empleado WHERE LOWER(nombre_empleado) LIKE '%"+nombre+"%');");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("id_empleado"),rs.getString("nombre_empleado"),rs.getString("cargo"), rs.getString("fecha_contratacion"), rs.getString("contacto"), rs.getString("salario")};
                model.addRow(fila);
            }
           tabla.setModel(model);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
 
        
         
    }




}






