/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.TipoPlato;
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
public class db_TipoPlato extends ConeDB {

    public void guardarTipoPlato(TipoPlato tp) {
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select * from tipo_plato where tipo='" + tp.getTipo() + "'");
            if (this.rs.next()) {
                JOptionPane.showMessageDialog(null, "El Tipo de plato ya existe");
            } else {
                this.ps = this.Conectar().prepareStatement("insert into tipo_plato(tipo) values(?)");
                this.ps.setString(1, tp.getTipo());
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

    public void ActualizarTipoPlato(TipoPlato tp) {
        try {
            this.rs = this.Conectar().createStatement().executeQuery("select * from tipo_plato where tipo='" + tp.getTipo() + "'");
            if (this.rs.next()) {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ACTUALIZAR CON EL MISMO NOMBRE");
            } else {
                this.ps = this.Conectar().prepareStatement("update tipo_plato set tipo=? where idtipo=?");
                this.ps.setString(1, tp.getTipo());
                this.ps.setInt(2, tp.getIdTipoPlato());
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

    public void EliminarTipoPlato(TipoPlato tp) {
        try {
            this.ps = this.Conectar().prepareStatement("delete from tipo_plato where idtipo=?");
            this.ps.setInt(1, tp.getIdTipoPlato());
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
            this.rs = this.Conectar().createStatement().executeQuery("select * from tipo_plato where tipo like '%" + dato + "%'");
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
            this.rs=this.Conectar().createStatement().executeQuery("select idtipo from tipo_plato where tipo='"+tipo+"'");
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
    
    public void llenarComboTipoPlato(JComboBox combo){
        DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select tipo from tipo_plato");
            modeloCombo.addElement("Seleccione");
            while (this.rs.next()) {                
                modeloCombo.addElement(this.rs.getObject(1));
            }
            combo.setModel(modeloCombo);
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
    }
}
