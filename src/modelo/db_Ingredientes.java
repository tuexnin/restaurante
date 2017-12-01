/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Ingrediente;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin CR
 */
public class db_Ingredientes extends ConeDB{
    
    public void guardar(Ingrediente ing){
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select * from ingrediente where nombre='"+ing.getNombre()+"'");
            if(this.rs.next()){
                JOptionPane.showMessageDialog(null, "ERROR: EL INGREIENTE YA EXISTE");
            }else{
                this.ps=this.Conectar().prepareStatement("insert into ingrediente values(?,?,?,?,?)");
                this.ps.setString(1, ing.getIdIngrediente());
                this.ps.setString(2, ing.getNombre());
                this.ps.setDouble(3, ing.getCantidad());
                this.ps.setString(4, ing.getMedida());
                this.ps.setString(5, ing.getIdAlmacen());
                int val=this.ps.executeUpdate();
                if (val==1) {
                    JOptionPane.showMessageDialog(null, "SE GUARDO EL INGREDIENTE CORRECTAMENTE");
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR EL INGREDIENTE");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.rs.close();
                if (this.ps!=null) {
                    this.ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void Actualizar(Ingrediente ing){
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select * from ingrediente where nombre='"+ing.getNombre()+"'");
            if (this.rs.next()) {
                JOptionPane.showMessageDialog(null, "EL ILGREDIENTE QUE DESEA MODIFICAR ");
            }else{
                this.ps=this.Conectar().prepareStatement("update ingrediente set nombre=?, cantidad=?, medida=?, idAlmacen=? where idIngrediente=?");
                this.ps.setString(1, ing.getNombre());
                this.ps.setDouble(2, ing.getCantidad());
                this.ps.setString(3, ing.getMedida());
                this.ps.setString(4, ing.getIdAlmacen());
                this.ps.setString(5, ing.getIdIngrediente());
                int val=this.ps.executeUpdate();
                if (val==1) {
                    JOptionPane.showMessageDialog(null, "SE ACTUALIZO EL INGREDIENTE");
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR: NO SE PUEDO ACTUALIZAR EL INGREDIENTE");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                this.Conectar().close();
                this.rs.close();
                if (this.ps!=null) {
                    this.ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void Eliminar(Ingrediente ing){
        try {
            this.ps=this.Conectar().prepareStatement("delete from ingrediente where idIngrediente=?");
            this.ps.setString(1, ing.getIdIngrediente());
            int val=this.ps.executeUpdate();
            if (val==1) {
                JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE");
            }else{
                JOptionPane.showMessageDialog(null, "ERROR: NO SE PUDO ELIMINO");
            }
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
    
    public void Listar(JTable table, String dato){
        String [] titulos={"CODIGO","NOMBRE","CANTIDAD","MEDIDA","ALMACEN"};
        DefaultTableModel modeloTabla=new DefaultTableModel(null,titulos);
        Object []aux =new Object[5];
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select ingrediente.idIngrediente, ingrediente.nombre, ingrediente.cantidad, ingrediente.medida,tipo_almacen.tipo \n" +
                                                                    "from ingrediente\n" +
                                                                    "inner join almacen on almacen.idAlmacen=ingrediente.idAlmacen\n" +
                                                                    "inner join tipo_almacen on tipo_almacen.idtipo_almacen=almacen.idtipo\n" +
                                                                    "where ingrediente.nombre like '%"+dato+"%'");
            while (this.rs.next()) {                
                for (int i = 0; i < 5; i++) {
                    aux[i]=this.rs.getObject(i+1);
                }
                modeloTabla.addRow(aux);
            }
            table.setModel(modeloTabla);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public String sacarIdDelTipoAlmacen(String dato){
        String id="";
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select almacen.idAlmacen from almacen\n" +
                                                                   "inner join tipo_almacen on tipo_almacen.idtipo_almacen=almacen.idtipo\n" +
                                                                   "where tipo_almacen.tipo='"+dato+"';");
            if (this.rs.next()) {
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
    
    
     public void LLenarComboTipoALmacen(JComboBox combo){
        DefaultComboBoxModel modeloCombo=new DefaultComboBoxModel();
        try {
            this.rs=this.Conectar().createStatement().executeQuery("select tipo from tipo_almacen where tipo!='bebidas'");
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
     
    public String SacarIDIngredientes(String dato){
        String valor="";
        try {
            this.rs=this.Conectar().createStatement().executeQuery("SELECT idIngrediente FROM ingrediente where nombre='"+dato+"'");
            if(this.rs.next()){
                valor=this.rs.getObject(1).toString();
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
        return valor;
    }
}
