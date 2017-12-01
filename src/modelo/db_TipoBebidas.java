/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import entidades.Tipo_bebidas;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin CR
 */
public class db_TipoBebidas extends ConeDB{
    private boolean res=false;
    private int valor=0;
    
    
    public void guardar(Tipo_bebidas tb) {
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select * from tipo_bebidas where tipo='" + tb.getTipo() + "'");
            if (this.rs.next()) {
                JOptionPane.showMessageDialog(null, "El Tipo de bebidas ya existe");
            } else {
                this.ps = this.Conectar().prepareStatement("insert into tipo_bebidas(tipo) values(?)");
                this.ps.setString(1, tb.getTipo());
                this.ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
     public void Actualizar(Tipo_bebidas tb) {
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select * from tipo_bebidas where tipo='" + tb.getTipo() + "'");
            if (this.rs.next()) {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ACTUALIZAR CON EL MISMO NOMBRE");
            } else {
                this.ps = this.Conectar().prepareStatement("update tipo_bebidas set tipo=? where idtipo=?");
                this.ps.setString(1, tb.getTipo());
                this.ps.setInt(2, tb.getIdTipoBebidas());
                this.ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Eliminar(Tipo_bebidas tb) {
        try {
            this.ps = this.Conectar().prepareStatement("delete from tipo_bebidas where idtipo=?");
            this.ps.setInt(1, tb.getIdTipoBebidas());
            this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.Conectar().close();
                this.ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Listar(JList lista, String dato) {
        DefaultListModel modeloLista = new DefaultListModel();
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select * from tipo_bebidas where tipo like '%" + dato + "%'");
            while (this.rs.next()) {
                modeloLista.addElement(this.rs.getObject(2));
            }
            lista.setModel(modeloLista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String sacarID(String tipo){
        String val="";
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select idtipo from tipo_bebidas where tipo='"+tipo+"'");
            if (this.rs.next()) {
                val=this.rs.getObject(1).toString();
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
        return val;
    }
}
