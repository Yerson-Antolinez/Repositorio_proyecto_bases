/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Controlador;

import java.sql.ResultSet;
import com.mycompany.laplaya.Modelo.Tipo_Cliente;
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
public class CTipo_Cliente {   
    public void registrarTipoCliente(Tipo_Cliente tipo_cliente){  //crea el metodo para registrar el cliente 
        try {
            Statement tc = Conexion.getConect().createStatement();
            tc.execute("insert into tipo_cliente(id_tipo_cliente, estado)values( '"+tipo_cliente.getId_tipo_cliente()+"','"+tipo_cliente.getEstado()+"')");
            JOptionPane.showMessageDialog(null, "Registrado");
            
        } catch (SQLException ex) {
            Logger.getLogger(CTipo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Registrar");
        }
    }
    
    
    public void eliminarTipoCliente(Tipo_Cliente tipo_cliente){  // crea el metodo para eliminar el cliente
        try {
            Statement tc = Conexion.getConect().createStatement();
            tc.execute("delete from tipo_cliente where id_tipo_cliente = ('"+tipo_cliente.getId_tipo_cliente()+"')");
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(CTipo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
        
            
        }
    
        
        public void modificarTipoCliente(Tipo_Cliente tipo_cliente){  // crea el metodo para eliminar el cliente
        try {
            Statement tc = Conexion.getConect().createStatement();
            tc.execute("update tipo_cliente set  estado = '"+tipo_cliente.getEstado()+"', descripcion = '"+tipo_cliente.getDescripcion()+"' where id_tipo_cliente = '"+tipo_cliente.getId_tipo_cliente()+"'");
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(CTipo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "fallo al modificar");}
    
    }
        

               
        public void cargarTablaTipoCliente(JTable tabla) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id_Tipo_Cliente");
        model.addColumn("estado");
        model.addColumn("descripcion");
     
 
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select * from tipo_cliente ");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("id_tipo_cliente"),rs.getString("estado"),rs.getString("descripcion")};
                model.addRow(fila);
            }
           tabla.setModel(model);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CTipo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
        
   public void cargarComboBoxTipo_Cliente(JComboBox combo) { //esto carga el combo box con la base de datos

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select estado from tipo_cliente group by estado ");
           model.addElement("Seleccione");    //aqui va un if
            while (rs.next()) {                
                model.addElement(rs.getString("estado"));
            }
           combo.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(CEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
   



        
      
        public void buscarTipoCliente(JTable tabla, Tipo_Cliente tipo_cliente) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id_Tipo_Cliente");
        model.addColumn("estado");
        model.addColumn("descripcion");
     
 
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select * from tipo_cliente where id_tipo_cliente = '"+tipo_cliente.getId_tipo_cliente()+"'");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("id_tipo_cliente"),rs.getString("estado"),rs.getString("descripcion")};
                model.addRow(fila);
                
            }
           tabla.setModel(model);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CTipo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
             
         
    }  
        
        }    
        
         
        
       
    }// cierra metodo buscar cliente
        
        
        
        
        
        
        
        
        
        
