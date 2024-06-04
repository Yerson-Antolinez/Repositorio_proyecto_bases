/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Controlador;


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
import com.mycompany.laplaya.Modelo.Producto;




/**
 *
 * @author Asus
 */
public class CProducto {
     public void registrarProducto(Producto producto){  try {
         //crea el metodo para registrar el cliente
         Statement tc = Conexion.getConect().createStatement();
         tc.execute("insert into producto(id_producto, nombre, descripcion, cantidad, tipo_producto, precio, fecha_vencimiento, ubicacion)values( '"+producto.getId_producto()+"','"+producto.getNombre()+"','"+producto.getDescripcion()+"', '"+producto.getCantidad()+"','"+producto.getTipo_producto()+"','"+producto.getPrecio()+"', '"+producto.getFecha_vencimiento()+"','"+producto.getUbicacion()+"')");
         JOptionPane.showMessageDialog(null, "Registrado");   
         } catch (SQLException ex) {
             Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Error al Registrar");
         }
     
     }
     
        public void cargarComboBoxTipo_producto(JComboBox combo) { //esto carga el combo box con la base de datos

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select tipo_producto.nombre as tipo_producto  from producto inner join tipo_producto on producto.tipo_producto=tipo_producto.id_tipo group by tipo_producto.nombre");
           model.addElement("Seleccione");    //aqui va un if
            while (rs.next()) {                
                model.addElement(rs.getString("tipo_producto"));
            }
           combo.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
        public void cargarTablaProducto(JTable tabla) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id_producto");
        model.addColumn("nombre");
        model.addColumn("decripcion");
        model.addColumn("cantidad");
        model.addColumn("tipo_producto");
        model.addColumn("precio");
        model.addColumn("fecha");
        model.addColumn("ubicacion");
        
     
 
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select producto.id_producto as id_producto, producto.nombre, producto.descripcion, producto.cantidad, tipo_producto.nombre as Tipo_Producto, precio, fecha_vencimiento, ubicacion.nombre as ubicacion from producto inner join tipo_producto on producto.tipo_producto = tipo_producto.id_tipo inner join ubicacion on ubicacion.id_ubicacion = producto.ubicacion order by producto.id_producto asc");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("id_producto"),rs.getString("nombre"),rs.getString("descripcion"),rs.getString("cantidad"),rs.getString("tipo_producto"), rs.getString("precio"),rs.getString("fecha_vencimiento"),rs.getString("ubicacion")};
                model.addRow(fila);
            }
           tabla.setModel(model);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
        public void cargarComboBoxUbicacion(JComboBox combo) { //esto carga el combo box con la base de datos

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select ubicacion.nombre as ubicacion  from producto inner join ubicacion on producto.ubicacion=ubicacion.id_ubicacion group by ubicacion.nombre");
           model.addElement("Seleccione");    //aqui va un if
            while (rs.next()) {                
                model.addElement(rs.getString("ubicacion"));
            }
           combo.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        }
      public void modificarProducto(Producto producto){  try {
         //crea el metodo para registrar el cliente
         Statement tc = Conexion.getConect().createStatement();
         tc.execute("update producto set nombre= '"+producto.getNombre()+"', descripcion= '"+producto.getDescripcion()+"', cantidad= '"+producto.getCantidad()+"', tipo_producto= '"+producto.getTipo_producto()+"', precio= '"+producto.getPrecio()+"', fecha_vencimiento= '"+producto.getFecha_vencimiento()+"', ubicacion='"+producto.getUbicacion()+"' where id_producto=  '"+producto.getId_producto()+"'");
         JOptionPane.showMessageDialog(null, "modificado");   
         } catch (SQLException ex) {
             Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Error ");
         }
     
     }
      
         public void eliminarProducto(Producto producto){  try {
         //crea el metodo para registrar el cliente
         Statement tc = Conexion.getConect().createStatement();
         tc.execute("delete from producto where id_producto=  ('"+producto.getId_producto()+"')");
         JOptionPane.showMessageDialog(null, "eliminado");   
         } catch (SQLException ex) {
             Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Error ");
         }
     
     }
        
         public void buscarProducto(JTable tabla, String nombre) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id_producto");
        model.addColumn("nombre");
        model.addColumn("decripcion");
        model.addColumn("cantidad");
        model.addColumn("tipo_producto");
        model.addColumn("precio");
        model.addColumn("fecha");
        model.addColumn("ubicacion");
        
     
 
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM producto WHERE LOWER(nombre) = (SELECT LOWER(nombre) FROM producto WHERE LOWER(nombre) LIKE '%"+nombre+"%');");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("id_producto"),rs.getString("nombre"),rs.getString("descripcion"),rs.getString("cantidad"),rs.getString("tipo_producto"), rs.getString("precio"),rs.getString("fecha_vencimiento"),rs.getString("ubicacion")};
                model.addRow(fila);
            }
           tabla.setModel(model);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
        



        
        
          
        
     
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
