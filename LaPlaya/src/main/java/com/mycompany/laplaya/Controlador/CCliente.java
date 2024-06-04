/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laplaya.Controlador;

import com.mycompany.laplaya.Modelo.Cliente;
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
public class CCliente {
    //para el combobox
    public void cargarComboBoxCliente(JComboBox combo) { //esto carga el combo box con la base de datos

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select estado from cliente inner join tipo_cliente on cliente.tipo_cliente = tipo_cliente.id_tipo_cliente group by estado ");
           model.addElement("Seleccione");    //aqui va un if
            while (rs.next()) {                
                model.addElement(rs.getString("estado"));
            }
           combo.setModel(model);
           
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    



    
    public void cargarTablaCliente(JTable tabla) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Cliente");
        model.addColumn("Nombre");
        model.addColumn("Tipo de Cliente");
        model.addColumn("Contacto");
        model.addColumn("Dirección");
    
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select id_cliente, nombre_cliente, estado as tipo_cliente, contacto, direccion from cliente inner join tipo_cliente on cliente.tipo_cliente = tipo_cliente.id_tipo_cliente order by id_cliente; ");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("id_cliente"),rs.getString("nombre_cliente"),rs.getString("tipo_cliente"), rs.getString("contacto"), rs.getString("direccion")};
                model.addRow(fila);
            }
           tabla.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
    }
    
    public void registrarCliente(Cliente cliente) {
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("insert into cliente(id_cliente, nombre_cliente, tipo_cliente, contacto, direccion)values( '" + cliente.getId_cliente() + "','" + cliente.getNombre_cliente()  + "','" + cliente.getTipo_cliente() + "', '" + cliente.getContacto() + "', '" + cliente.getDireccion() + "')");
            JOptionPane.showMessageDialog(null, "Registrado");
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Registrar");
        }
    }
    
    public void eliminarCliente(Cliente cli){
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from cliente where id_cliente = ('" + cli.getId_cliente() + "')");
            JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Eliminar");
        }
    }
    
    
        public void modificarCliente(Cliente cli){
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("update cliente set  nombre_cliente = '"+cli.getNombre_cliente()+"', tipo_cliente = '"+cli.getTipo_cliente()+"', contacto = '"+cli.getContacto()+"', direccion = '"+cli.getDireccion()+"' where id_cliente = '"+cli.getId_cliente()+"'");
            JOptionPane.showMessageDialog(null, "Modificado Correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Modificar");
        }
        
  }
        public void BuscarCliente(JTable tabla, Cliente cliente) {     /// esto  carga de la base de datos a netbeans
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Cliente");
        model.addColumn("Nombre");
        model.addColumn("tipo_cliente");
        model.addColumn("Contacto");
        model.addColumn("Dirección");
    
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet rs = st.executeQuery("select * from cliente where id_cliente = '"+cliente.getId_cliente()+"'");
            
            while (rs.next()) {                
              
                String []fila={rs.getString("id_cliente"),rs.getString("nombre_cliente"),rs.getString("tipo_cliente"), rs.getString("contacto"), rs.getString("direccion")};
                model.addRow(fila);
            }
           tabla.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
    }
    }

