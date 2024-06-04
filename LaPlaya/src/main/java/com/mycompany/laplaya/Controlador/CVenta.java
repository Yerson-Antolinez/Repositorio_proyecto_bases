/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Controlador;

import com.mycompany.laplaya.Modelo.Venta;
import java.sql.PreparedStatement;
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
public class CVenta {
    public void cargarComboBoxVCliente(JComboBox combo) { //esto carga el combo box con la base de datos

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select cliente.nombre_cliente from venta right join cliente on cliente.id_cliente=venta.clienteid group by nombre_cliente;");
            model.addElement("Seleccione");  
            while (rs.next()) {                
                model.addElement(rs.getString("nombre_cliente"));
            }
           combo.setModel(model);
           
        } catch (SQLException ex) {
            Logger.getLogger(CVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void cargarComboBoxVProducto(JComboBox combo) { //esto carga el combo box con la base de datos

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select producto.nombre from venta right join producto on producto.id_producto = venta.productoid group by producto.nombre ;");
            model.addElement("Seleccione");  
            while (rs.next()) {                
                model.addElement(rs.getString("nombre"));
            }
           combo.setModel(model);
           
        } catch (SQLException ex) {
            Logger.getLogger(CVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void cargarComboBoxVEmpleado(JComboBox combo) { //esto carga el combo box con la base de datos

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select empleado.nombre_empleado from venta inner join empleado on empleado.id_empleado = venta.empleadoid group by nombre_empleado; ");
//           ResultSet rs = st.executeQuery("select empleado.nombre_empleado from empleado; ");
             model.addElement("Seleccione");  
           
            while (rs.next()) {                
                model.addElement(rs.getString("empleado.nombre_empleado"));
            }
           combo.setModel(model);
           
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    public void cargarTablaVenta1(JTable tabla) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_producto");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        
    
        
     
 
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select id_producto, nombre, precio, cantidad from producto; ");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("ID_producto"),rs.getString("Nombre"), rs.getString("Precio"),rs.getString("Cantidad")};
                model.addRow(fila);
            }
           tabla.setModel(model);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
     
     public void cargarTablaVenta2(JTable tabla) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Venta");
        model.addColumn("Cliente");
        model.addColumn("Producto");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Fecha");
        model.addColumn("Empleado");
        model.addColumn("Venta total");
    
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select id_venta as ID_venta, cliente.nombre_cliente as Cliente, producto.nombre as Producto, producto.precio as Precio, Venta.cantidad as Cantidad, venta.fecha_venta as Fecha, empleado.nombre_empleado as Empleado, venta_total as 'Venta total' from Venta inner join cliente on venta.clienteid = cliente.id_cliente inner join producto on venta.productoid = producto.id_producto inner join empleado on venta.empleadoid = empleado.id_empleado order by id_venta;");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("ID_Venta"),rs.getString("Cliente"),rs.getString("Producto"),rs.getString("Precio"), rs.getString("Cantidad"), rs.getString("Fecha"), rs.getString("Empleado"), rs.getString("Venta total")};
                model.addRow(fila);
            }
           tabla.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(CVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
    }
     public void registrarVenta(Venta venta){  //crea el metodo para registrar el cliente 
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("insert into venta(id_venta, clienteid, productoid, cantidad, fecha_venta, empleadoid, venta_total) values ('"+venta.getId_venta()+"','"+venta.getClienteid()+"','"+venta.getProductoid()+"','"+venta.getCantidad()+"','"+venta.getFecha_venta()+"','"+venta.getEmpleadoid()+"','"+venta.getVenta_total()+"')");
            JOptionPane.showMessageDialog(null, "Registrado");
            
        } catch (SQLException ex) {
            Logger.getLogger(CTipo_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Registrar");
        }
    }
     
     
     
     public void buscarVentas(JTable tabla, int venta) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID_Venta");
        model.addColumn("Cliente");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Fecha");
        model.addColumn("Empleado");
        model.addColumn("Venta_total");
    
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("SELECT venta.id_venta AS ID_Venta, cliente.nombre_cliente AS Cliente, producto.nombre AS Producto, venta.cantidad AS Cantidad, venta.fecha_venta AS Fecha, empleado.nombre_empleado AS Empleado, venta.venta_total AS Venta_Total FROM venta INNER JOIN cliente ON venta.clienteid = cliente.id_cliente INNER JOIN producto ON venta.productoid = producto.id_producto INNER JOIN empleado ON venta.empleadoid = empleado.id_empleado WHERE venta.id_venta = "+venta+" ORDER BY venta.id_venta;");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("ID_Venta"),rs.getString("Cliente"),rs.getString("Producto"), rs.getString("Cantidad"), rs.getString("Fecha"), rs.getString("Empleado"), rs.getString("Venta_total")};
                model.addRow(fila);
            }
           tabla.setModel(model);
           JOptionPane.showMessageDialog(null, "exitoooooo");
            
        } catch (SQLException ex) {
            Logger.getLogger(CVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "nulooooooo");
        }
     }
     




     
     public void modificarVenta(Venta venta){  //crea el metodo para registrar el cliente 
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("update venta set clienteid= '"+venta.getClienteid()+"', productoid= '"+venta.getProductoid()+"', cantidad= '"+venta.getCantidad()+"', fecha_venta= '"+venta.getFecha_venta()+"', empleadoid= '"+venta.getEmpleadoid()+"', venta_total= '"+venta.getVenta_total()+"' where id_venta=  '"+venta.getId_venta()+"'");
            JOptionPane.showMessageDialog(null, "Modificado");
            
        } catch (SQLException ex) {
            Logger.getLogger(CVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error ");
        }
    }
      public void eliminarVenta(Venta venta){  //crea el metodo para registrar el cliente 
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from venta where id_venta = ('" + venta.getId_venta() + "')");
            JOptionPane.showMessageDialog(null, "eliminado");
            
        } catch (SQLException ex) {
            Logger.getLogger(CVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
  
  
    
}


}