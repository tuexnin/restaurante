/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Platos;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin CR
 */
public class db_Platos extends ConeDB{
    
    public void GuardarPlatos(Platos plato){
        try {
            this.ps=this.Conectar().prepareStatement("insert into platos values(?,?,?)");
            this.ps.setString(1, plato.getCodigoPlato());
            this.ps.setString(2, plato.getNombre());
            this.ps.setInt(3, plato.getIdTipo());
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
    
    public void ActualizarPlatos(Platos plato){
        try {
            this.ps=this.Conectar().prepareStatement("update platos set nombre=?, idtipo=? where codigoPlato=?");
            this.ps.setString(1, plato.getNombre());
            this.ps.setInt(2, plato.getIdTipo());
            this.ps.setString(3, plato.getCodigoPlato());
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
    
    public void Eliminar(Platos plato){
        try {
            this.ps=this.Conectar().prepareStatement("delete from platos where codigoPlato=?");
            this.ps.setString(1, plato.getCodigoPlato());
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
    
    
    public void Listar(JTable tabla,String dato){
        String [] titulos={"CODIGO","PLATO","TIPO PLATO"};
        DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
        Object [] aux=new Object[3];
        try {
            this.rs=this.Conectar().createStatement().executeQuery("CALL listarPlatos('"+dato+"')");
            while (this.rs.next()) {                
                for (int i = 0; i < 3; i++) {
                    aux[i]=this.rs.getObject(i+1);
                }
                modeloTabla.addRow(aux);
            }
            tabla.setModel(modeloTabla);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
