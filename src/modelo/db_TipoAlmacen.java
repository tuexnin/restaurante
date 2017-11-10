/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Tipo_almacen;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin CR
 */
public class db_TipoAlmacen extends ConeDB{
    
    public void Guardar(Tipo_almacen ta){
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select * from tipo_almacen where tipo='"+ta.getTipo()+"'");
            if(this.rs.next()){
                JOptionPane.showMessageDialog(null, "EL TIPO DE ALMACEN YA EXISTE");
            }else{
                this.ps=this.Conectar().prepareStatement("insert into tipo_almacen(tipo) values(?)");
                this.ps.setString(1, ta.getTipo());
                this.ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.rs.close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void Actualizar(Tipo_almacen ta){
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select * from tipo_almacen where tipo='"+ta.getTipo()+"'");
            if(this.rs.next()){
                JOptionPane.showMessageDialog(null, "EL TIPO DE ALMACEN YA EXISTE");
            }else{
                this.ps=this.Conectar().prepareStatement("update tipo_almacen set tipo=? where idtipo_almacen=?");
                this.ps.setString(1, ta.getTipo());
                this.ps.setInt(2, ta.getIdTipoAlmacen());
                this.ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.rs.close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void Eliminar(Tipo_almacen ta){
        try {
            this.ps=this.Conectar().prepareStatement("delete from tipo_almacen where idtipo_almacen=?");
            this.ps.setInt(1, ta.getIdTipoAlmacen());
            this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public String SacarID(String tipo){
        String id="";
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select idtipo_almacen from tipo_almacen where tipo='"+tipo+"'");
            if(this.rs.next()){
                id=this.rs.getObject(1).toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
    
    public void Listar(JList lista,String dato){
        DefaultListModel modeloLista=new DefaultListModel();
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select tipo from tipo_almacen where tipo like '%"+dato+"%'");
            while (this.rs.next()) {                
                modeloLista.addElement(this.rs.getObject(1));
            }
            lista.setModel(modeloLista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void LLenarComboTipoALmacen(JComboBox combo){
        DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select tipo from tipo_almacen");
             
        } catch (Exception e) {
        }
    }
    
}
